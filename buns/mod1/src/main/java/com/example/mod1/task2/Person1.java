package com.example.mod1.task2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("personBean")
public class Person1 {
//    @Autowired
//    @Qualifier("CatBean")
    private Pet1 pet;
//    @Value("${person.surname}")
    private String surname;
//    @Value("${person.age}")
    private int age;

    @Autowired
    public Person1(@Qualifier("dog1") Pet1 pet){
        System.out.println("Person bean is created");
        this.pet = pet;
    }

//    public Person1(){
//        System.out.println("Person bean is created");
//    }

//    @Autowired
//    @Qualifier("dog1")
    public void setPet(Pet1 pet) {
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
