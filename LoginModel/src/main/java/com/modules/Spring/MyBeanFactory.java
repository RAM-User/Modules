package com.modules.Spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyBeanFactory {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("services.xml", "daos.xml");

    }
}
