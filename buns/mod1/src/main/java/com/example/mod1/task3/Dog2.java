package com.example.mod1.task3;


import org.springframework.stereotype.Component;

@Component("dog2")
public class Dog2 implements Pet2 {
    //    private String name;
    public Dog2() {
        System.out.println("Dog2 bean is created");
    }

    @Override
    public void say() {
        System.out.println("Bow-Wow");
    }
//    @PostConstruct
//    public void init(){
//        System.out.println("Class Dog: init method");
//    }
//    @PreDestroy
//    public void destroy(){
//        System.out.println("Class Dog: destroy method");


//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getName() {
//        return name;
//    }
}
