package com.example.mod1.task4;


public class Dog3 implements Pet3 {
    public Dog3() {
        System.out.println("Dog2 bean is created");
    }

    @Override
    public void say() {
        System.out.println("Bow-Wow");
    }
}
