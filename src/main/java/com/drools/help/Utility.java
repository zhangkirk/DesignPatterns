package com.drools.help;

import org.drools.core.spi.KnowledgeHelper;

/**
 * Created by Administrator on 2018/1/29.
 */
public class Utility {
    public static void help(final KnowledgeHelper drools, final String message){
        System.out.println(message);
        System.out.println("\nrule triggered: " + drools.getRule().getName());
    }

    public static void helper(final KnowledgeHelper drools){
        System.out.println("\nrule triggered: " + drools.getRule().getName());
    }
}
