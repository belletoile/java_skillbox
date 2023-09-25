package com.example.mod1.task4;

public class Person3 {
    private Pet3 pet;

    public Person3(Pet3 pet){
        System.out.println("Person bean is created");
        this.pet = pet;
    }

    public void setPet(Pet3 pet) {
        System.out.println("Class Person: set Pet");
        this.pet = pet;
    }

    public void callYourPet(){
        System.out.println("Hello my lovely pet");
        pet.say();
    }
}
