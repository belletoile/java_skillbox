package com.example.mod1.task4;


public class Dog3 implements Pet3 {
    //    private String name;
    public Dog3() {
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
