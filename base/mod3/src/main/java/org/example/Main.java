package org.example;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Scanner in = new Scanner(System.in);
        System.out.println("Введите имя: ");
        String name = in.nextLine();
        System.out.println("Введите логин: ");
        String login = in.nextLine();
        System.out.println("Введите хобби через запятую: ");
        String[] hobbies = in.nextLine().split(",");
        System.out.println("Введите возраст: ");
        int age = in.nextInt();


        User user = new User(name, login, age, hobbies);

        try {
            FileOutputStream fos = new FileOutputStream("data.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(user); //сериализация объекта

            System.out.println("Сериазиация прошла успешно в файл data.txt");

            oos.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        try {
            FileInputStream fis = new FileInputStream("data.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);

            User deserializedUser = (User) ois.readObject();
            System.out.println(deserializedUser);

            ois.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}