package com.example.mod1.task3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


@Component("person2Bean")
public class Person2 {
    //    @Autowired
//    @Qualifier("CatBean")
    private Pet2 pet;
    //    @Value("${person.surname}")
    private String surname;
    //    @Value("${person.age}")
    private int age;

    @Autowired
    public Person2(@Qualifier("Cat2Bean") Pet2 pet){
        System.out.println("Person bean is created");
        this.pet = pet;
    }

//    public Person1(){
//        System.out.println("Person bean is created");
//    }

    //    @Autowired
//    @Qualifier("dog1")
    public void setPet(Pet2 pet) {
        System.out.println("Class Person: set Pet");
        this.pet = pet;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        System.out.println("class Person: set surname");
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        System.out.println("class Person: set age");
        this.age = age;
    }

    public void callYourPet(){
        System.out.println("Hello my lovely pet");
        pet.say();
    }
}


