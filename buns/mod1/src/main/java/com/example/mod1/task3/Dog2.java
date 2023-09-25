package com.example.mod1.task3;


import org.springframework.stereotype.Component;

@Component("dog2")
public class Dog2 implements Pet2 {
    public Dog2() {
        System.out.println("Dog2 bean is created");
    }

    @Override
    public void say() {
        System.out.println("Bow-Wow");
    }

}
