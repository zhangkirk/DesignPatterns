package com.algorithm.test1;

/**
 * Created by Administrator on 2017/6/23.
 */
public class Test1 {
    public static void main(String[] args) {
        int number = 16;
        //原始数二进制
        printInfo(number);
        number = number >> 5;
        //左移一位
        printInfo(number);

        //左移一位 == *2  右移一位 /2
        //左移一位 == *2*2  右移一位 /2/2
        printInfo( 1 << 4);

        printInfo(9 >> 4);
        printInfo(48);

        printInfo(1 << 30);





     /*   number = number << 4;
        printInfo(number);*/

    }


    private static void printInfo(int num){
        System.out.println("===");
        System.out.println(Integer.toBinaryString(num));
        System.out.println(num);
    }


}
