package com.algorithm.test1;

import com.dp3.Iterator.*;
import com.ds.call.Li;

import java.util.*;
import java.util.Iterator;

/**
 * Created by Administrator on 2017/6/22.
 */
public class Test {
    public static void main(String[] args) {
 /*       int[] x = {5};
        String[] p = (String[])Array.newInstance(String.class,x);
        p[0] = "1";
        p[1]="2";
        String[] p1 = Arrays.copyOf(p, 10);
        System.out.println(p1.length);*/

  /*      Vector<String> v = new Vector<String>(10);
        v.insertElementAt("0",0);
        v.insertElementAt("1", 0);

        List<String> x =  v.subList(0, 1);
        System.out.println(v);*/

       /* Object[] elementData = new Object[10];
        elementData[0] = "0";
        elementData = Arrays.copyOf(elementData, 20);
        System.out.println("=");*/

      /*  List<String> list = new ArrayList<String>();
        *//*list.add("1");
        String old = list.set(0,"2");
        System.out.println(old);*//*

        list.add(0,"0");
        list.add(1,"1");
        list.add(0,"2");
        String x = list.remove(0);
        System.out.println("==");*/

        /*Integer x = 1;

        Integer y = x;

        x = 2;
        System.out.println(y);*/

   /*     TestInfo test = new TestInfo("1");
        System.out.println(test);
        TestInfo t1 = test;
        System.out.println(t1);
        TestInfo test1 =  new TestInfo("2");
        test = test1;

        System.out.println("==");*/


       /* List<String> s = new ArrayList<String>();
        s.add("1");
        s.add("2");

        List<String> list = new LinkedList<String>();
        list.add("0");
        list.addAll(0, s);
        Iterator<String> x =  list.iterator();
        while (x.hasNext()){
            System.out.println(x.next());
        }*/

/*        List<String> list = new LinkedList<String>();
        list.add("0");
        list.add("1");
        list.add("2");
        list.add("3");
        Iterator<String> it = list.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }*/


    /*    List<String> list1 = new ArrayList<String>();
        list1.add("0");
        list1.add("1");
        list1.add("2");
        Iterator<String> it1 = list1.iterator();
        while (it1.hasNext()){
            System.out.println(it1.next());
        }*/
        System.out.println(hash("0"));
        /*String a= "Aa";
        String b= "BB";
        System.out.println(hash(a));
        System.out.println(hash(b));*/


    /*    Map<String,String> map = new HashMap<String, String>();
        map.put("Aa","s0");
//        map.put("1","s1");
        map.put("BB", "s2");
        map.get("Aa");*/



       /* for (Map.Entry<String, String> stringStringEntry : map.entrySet()) {
            System.out.println(stringStringEntry.hashCode());
        }*/


       /* Set<String> set = new HashSet<String>();
        set.add("0");
        set.add("1");
        set.add("2");*/
        Queue<String> queue = new ArrayDeque<String>();
        queue.add("1");



    }

    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }
}
