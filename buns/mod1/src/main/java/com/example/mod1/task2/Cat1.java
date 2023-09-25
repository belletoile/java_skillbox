package com.example.mod1.task2;

import org.springframework.stereotype.Component;

public class Cat1 implements Pet1{
    public Cat1(){
        System.out.println("Cat bean is created");
    }
    @Override
    public void say() {
        System.out.println("Meow-meow");
    }
}
