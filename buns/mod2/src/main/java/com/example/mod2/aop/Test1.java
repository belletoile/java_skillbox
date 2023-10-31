package com.example.mod2.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test1 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MyConfig.class);
        UniLibrary uniLibrary = context.getBean("uniLibrary", UniLibrary.class);
        Book book = context.getBean("book", Book.class);
        uniLibrary.getBook(book);
        String bookName = uniLibrary.returnMagazine();
        System.out.println("Вернули эту книгу:" + bookName);
        uniLibrary.getMagazine();
        uniLibrary.returnBook();


        context.close();
    }
}
