package com.compiler;

import javassist.*;
import org.codehaus.commons.compiler.CompileException;
import org.codehaus.janino.SimpleCompiler;

import java.lang.management.ManagementFactory;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Administrator on 2017/7/21.
 */
public class Compiler {
    /**
     * 代理前缀 <code>PROXY_FLAG</code>
     */
    public static final String PROXY_PREFIX = "AppKitGen";

    /**
     * 进程id <code>pid</code>
     */
    public static final int PID = Integer.parseInt(ManagementFactory.getRuntimeMXBean().getName().split("@")[0]);

    /**
     * 类创建计数器 <code>subscriberCounter</code>
     */
    public static final AtomicLong counter;

    static {
        long initializerCounter = System.currentTimeMillis();
        //- 放大时间
        initializerCounter = ((initializerCounter << 24) >> 8) & Long.MAX_VALUE; //1. 时间放大 、2. 预留第一位，最后两位（全0表示）
        initializerCounter = initializerCounter | ((((PID << 25) >> 1)) & Integer.MAX_VALUE); //1. 取出当前进程id取高8位填充时间第一位。
        counter = new AtomicLong(initializerCounter);

    }

    private Compiler() {

    }

    private static class CompilerHolder {

        private static final Compiler INSTANCE = new Compiler();
    }

    public static Compiler getInstance() {

        return CompilerHolder.INSTANCE;
    }

    @SuppressWarnings("unchecked")
    public <T> Class<T> compilerJavaCode(String className, String src) {
        try {
            SimpleCompiler compiler = new SimpleCompiler();

            compiler.cook(src);

            Class<T> targetType = (Class<T>) compiler.getClassLoader().loadClass(className);

            return targetType;
        } catch (CompileException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public CtClass newCtClass(Class supperClass) {

        try {
            ClassPool classPool = new ClassPool(true);

            ClassPath classPath = new ClassClassPath(this.getClass());

            classPool.insertClassPath(classPath);

            String dynamicClassName = genClassName(supperClass);

            CtClass ctClass = classPool.makeClass(dynamicClassName);

            if (supperClass != null & supperClass != Object.class) {
                if (supperClass.isInterface()) {
                    ctClass.setInterfaces(new CtClass[] { classPool.get(supperClass.getName()) });
                } else {
                    ctClass.setSuperclass(classPool.get(supperClass.getName()));
                }
            }

            return ctClass;
        } catch (NotFoundException | CannotCompileException e) {
            throw new CompilerException(String.format("创建CtClass过程中出错supperClass = %s", supperClass), e);
        }
    }

    @SuppressWarnings({ "rawtypes" })
    public Compiler methodWeave(CtClass ctClass, Class supperClass, String src) {

        try {
            ctClass.addMethod(CtNewMethod.make(src, ctClass));
        } catch (CannotCompileException e) {
            throw new CompilerException(String.format("方法织入过程中出现错误supperClass = %s,methodDefinition = %s", supperClass,
                    src), e);
        }
        return this;
    }

    @SuppressWarnings("unchecked")
    public <T> T newInstance(CtClass ctClass, Class<?>[] parameterTypes, Object[] parameters) {

        T target = null;
        try {
            if (parameterTypes == null || parameterTypes.length == 0) {
                target = (T) ctClass.toClass().newInstance();
            } else {

                Constructor<T> constructor = ctClass.toClass().getDeclaredConstructor(parameterTypes);
                target = constructor.newInstance(parameters);
            }
        } catch (NoSuchMethodException | SecurityException | CannotCompileException | InstantiationException
                | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            throw new CompilerException(String.format("构建过程中出现错误CtClass=%s", ctClass), e);
        }
        return target;
    }

    public void constructImplement(CtClass ctClass, String constructor) {

        try {
            ctClass.addConstructor(CtNewConstructor.make(constructor, ctClass));
        } catch (CannotCompileException e) {
            throw new CompilerException(String.format("构建过程中出现错误class = %s,constructorDefinition = %s", ctClass,
                    constructor), e);
        }
    }

    public static <T> String genClassName(Class<T> supperClass) {

        StringBuilder className = new StringBuilder();
        className.append("com.yiji.adk.compiler.").append(PROXY_PREFIX).append(supperClass.getSimpleName())
                .append(counter());
        return className.toString();

    }

    public static long counter() {

        return counter.getAndAdd(1L);
    }
}
