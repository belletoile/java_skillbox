package com.example.mod1.task4;

public class Cat3 implements Pet3 {
    public Cat3(){
        System.out.println("Cat bean is created");
    }
    @Override
    public void say() {
        System.out.println("Meow-meow");
    }
}
