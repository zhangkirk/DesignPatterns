package com.dp4.visitor2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/6/15.
 */
public class Test {
    public static void main(String[] args) {
        Service service1 = new Saving();
        Service service2 = new Fund();
        Service service3 = new Draw();
        List<Service> ls = new ArrayList<Service>();
        ls.add(service1);
        ls.add(service2);
        ls.add(service3);
        for (Service service : ls) {
            if (service instanceof Saving) {
                System.out.println("存款");
            } else if (service instanceof Fund) {
                System.out.println("基金");
            } else if (service instanceof Draw) {
                System.out.println("提款");
            }
        }
        //上述的问题是随着业务量增大 代码维护量会非常的大 需要不断的去判断


    }
}
