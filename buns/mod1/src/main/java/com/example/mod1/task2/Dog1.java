package com.example.mod1.task2;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class Dog1 implements Pet1 {
    //    private String name;
    public Dog1(){
        System.out.println("Dog bean is created");
    }
    @Override
    public void say (){
        System.out.println("Bow-Wow");
    }
    @PostConstruct
    public void init(){
        System.out.println("Class Dog: init method");
    }
    @PreDestroy
    public void destroy(){
        System.out.println("Class Dog: destroy method");
    }
}
