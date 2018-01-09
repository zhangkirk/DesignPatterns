package com.algorithm.test1;

import java.util.Objects;

/**
 * Created by Administrator on 2017/6/28.
 */
public class Test2 {
    public static void main(String[] args) {
//        System.out.println(2^3);
    /*    System.out.println(Objects.hashCode("0"));
        System.out.println(Objects.hashCode("s0"));
        System.out.println(Objects.hashCode("0") ^ Objects.hashCode("s0"));
        System.out.println(48^13);
        System.out.println(48^3613);
        System.out.println(50^3615);*/



        System.out.println(Objects.hashCode("2"));
//        System.out.println(Objects.hashCode("s2"));
//        System.out.println(Objects.hashCode("2") ^ Objects.hashCode("s2"));

        String key = "2";
        int h =  key.hashCode();
        System.out.println(h);
        int hash = (key == null) ? 0 : (1) ^ (1 >>> 16);
        System.out.println(hash);
    }



}
