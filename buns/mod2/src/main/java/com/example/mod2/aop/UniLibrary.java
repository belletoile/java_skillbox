package com.example.mod2.aop;


import org.springframework.stereotype.Component;

@Component
public class UniLibrary {
    public void getBook(Book book) {
        System.out.println("Мы берем книгу из UniLibrary " + book.getName());
        System.out.println("-------------------------------------------------");
    }

    public void getMagazine() {
        System.out.println("Мы берем журнал из UniLibrary");
        System.out.println("-------------------------------------------------");
    }

    public String returnBook() {
        System.out.println("Мы возвращаем книгу в UniLibrary ");
        return "Преступление и наказание";
    }

    public String returnMagazine() {
        int x = 10/0;
        System.out.println("Мы возвращаем журнал в UniLibrary ");
        return "Преступление и наказание";
    }

}
