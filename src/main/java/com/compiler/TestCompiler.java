package com.compiler;

/**
 * Created by Administrator on 2017/7/21.
 */
public class TestCompiler {
    public static void main(String[] args) {

        try {
            Compiler compiler = (Compiler) Compiler.getInstance().compilerJavaCode("test", "df").newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }
}
