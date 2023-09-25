package com.example.mod1.task2;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ScopeTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext3.xml");

        Dog1 myDog = context.getBean("dog1", Dog1.class);
        Dog1 yourDog = context.getBean("dog1", Dog1.class);

        System.out.println("Переменные ссылаются на один и тот же объект?" + (myDog==yourDog));
        System.out.println(myDog);
        System.out.println(yourDog);

        context.close();
    }
}
