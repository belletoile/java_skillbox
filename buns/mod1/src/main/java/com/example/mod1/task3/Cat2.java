package com.example.mod1.task3;

import org.springframework.stereotype.Component;

public class Cat2 implements Pet2 {
    public Cat2(){
        System.out.println("Cat bean is created");
    }
    @Override
    public void say() {
        System.out.println("Meow-meow");
    }
}
