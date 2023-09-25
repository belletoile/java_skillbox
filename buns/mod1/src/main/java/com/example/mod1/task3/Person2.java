package com.example.mod1.task3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;


@Component("person2Bean")
@PropertySource("classpath:application.properties")
public class Person2 {
    @Autowired
    public Pet2 pet;
    @Value("${person.surname}")
    public String surname;
    @Value("${person.age}")
    public int age;


    public Person2(Pet2 pet){
        System.out.println("Person bean is created");
        this.pet = pet;
    }

    public void callYourPet(){
        System.out.println("Hello my lovely pet");
        pet.say();
    }
}


