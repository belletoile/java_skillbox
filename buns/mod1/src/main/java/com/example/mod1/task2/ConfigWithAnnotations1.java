package com.example.mod1.task2;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConfigWithAnnotations1 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext3.xml");

        Person1 person = context.getBean("personBean", Person1.class);
        person.callYourPet();

        System.out.println(person.getSurname());
        System.out.println(person.getAge());

//        Cat1 myCat = context.getBean("CatBean", Cat1.class);
//        myCat.say();

        context.close();
    }
}
