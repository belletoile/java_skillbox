package com.example.mod1.task4;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test7 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MyConfig1.class);

//        Pet3 cat = context.getBean("cat3Bean", Pet3.class);
//        cat.say();

        Person3 person = context.getBean("person3Bean", Person3.class);
        person.callYourPet();

        context.close();
    }
}
