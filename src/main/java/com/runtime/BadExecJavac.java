package com.runtime;

import java.io.IOException;

public class BadExecJavac {

    public static void main(String[] args) {
        try {
            Runtime rt = Runtime.getRuntime();
            rt.freeMemory();

            Process proc = rt.exec("javac");
            int exitVal = proc.waitFor();
            System.out.println("Process exitValue: " + exitVal);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
