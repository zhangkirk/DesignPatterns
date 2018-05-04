package com.scanning;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;

import java.util.Set;

public class Test {
    public static void main(String[] args) throws Exception {

        ClassPathScanningCandidateComponentProvider p = new ClassPathScanningCandidateComponentProvider(true);
        Set<BeanDefinition> set = p.findCandidateComponents("com.scanning");
        for (BeanDefinition beanDefinition : set) {
            System.out.println(beanDefinition.getBeanClassName());
        }
    }
}
