package com.algorithm.kmp;

/**
 * Created by Administrator on 2017/7/6.
 */
public class KMPMatch {
    public static void main(String[] args) {
     /*   String s = "ababcababa"; // 主串
        String t = "ababa"; // 模式串*/

        String s = "ababcababa"; // 主串
        String t = "abcdabd"; // 模式串
        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();
        System.out.println(KMPMatch(ss, tt)); // KMP匹配字符串
    }


    public static int KMPMatch(char[] s,char[] p){
        int[] next = getNext(p);
        for (int i : next) {
            System.out.print(i + " ");
        }
        System.out.println("");
        int i=0;
        int j=0;
        int num = 0;
        while(i<s.length) {
            num++;
            if(j==-1||s[i]==p[j]) {
                i++;
                j++;
            } else {
                j=next[j];       //消除了指针i的回溯
            }
            if(j==p.length){
                System.out.println("循环次数" + num);
                return i-p.length;
            }
        }
        return -1;
    }


   public static  int[] getNext(char[] p) {
        int[] next = new int[p.length];
        int j,k;
        next[0]=-1;
        j=0;
        k=-1;
        while(j<p.length-1) {
            if(k==-1||p[j]==p[k]){    //匹配的情况下,p[j]==p[k]
                j++;
                k++;
                next[j]=k;
            }else{                    //p[j]!=p[k]
                k=next[k];
            }
        }
        return next;
    }
}
