package com.runtime;

import java.io.*;

public class RuntimeTest {
    public static void main(String[] args) {
        methodA();
//        methodB();
    }

    public static void methodB() {

        BufferedReader br = null;
        try {

            Process proc = Runtime.getRuntime().exec("ping www.baidu.com");

            InputStream in = proc.getInputStream();

            br = new BufferedReader(new InputStreamReader(in, "GBK"));
            String line = null;

            while((line=br.readLine())!=null){
                System.out.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            if(br!=null){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void methodA() {

        InputStream in = null;
        try {

            Process proc = Runtime.getRuntime().exec("ping www.baidu.com");

            in = proc.getInputStream();

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            in = proc.getInputStream();

            byte[] buf = new byte[1024];
            int len = 0;
            while ((len = in.read(buf, 0, 1024)) != -1) {
                baos.write(buf, 0, len);
            }

            byte[] arr = baos.toByteArray();
            String result = new String(arr, "GBK");

            System.out.println("result="+result);

        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            if(in!=null){
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}

