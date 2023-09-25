package com.example.mod1.task3;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test6 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MyConfig.class);

        Person2 person = context.getBean("person2Bean", Person2.class);
        person.callYourPet();

        context.close();
    }
}
