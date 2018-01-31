package com.drools.compiler;

import com.compiler.CompilerException;
import org.codehaus.commons.compiler.CompileException;
import org.codehaus.janino.SimpleCompiler;

/**
 * Created by Administrator on 2018/1/29.
 */
public class Compiler {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        String src = "package com.drools.compiler;\n" +
                "\n" +
//                "import com.drools.compiler.Cinter;\n" +
                "public class Test2 extends Cinter {\n" +
                "\n" +
                "    public void cout() {\n" +
                "        System.out.println(\"====\");\n" +
                "    }\n" +
                "}";
        String className = "com.drools.compiler.Test2";

        Class<Cinter> targetType =  Compiler.compilerJavaCode(className, src);

        Cinter c = targetType.newInstance();
        c.cout();
    }




    public static  <T> Class<T> compilerJavaCode(String className, String src) {

        try {
            SimpleCompiler compiler = new SimpleCompiler();

            compiler.cook(src);

            Class<T> targetType = (Class<T>) compiler.getClassLoader().loadClass(className);

            return targetType;
        } catch (CompileException | ClassNotFoundException e) {
            throw new CompilerException(String.format("动态编译出错，className=%s src=%s", className, src), e);
        }
    }
}
