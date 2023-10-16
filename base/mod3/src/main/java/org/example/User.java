package org.example;

import java.io.Serializable;

public class User implements Serializable {
    public String name;
    public String login;
    public int age;
    public String[] hobbies;

    public User(String name, String login, int age, String[] hobbies) {
        this.name = name;
        this.login = login;
        this.age = age;
        this.hobbies = hobbies;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String hobby : hobbies) {
            sb.append(hobby).append("\n");
        }
        sb.delete(sb.length() - 1, sb.length());

        return "Пользователь: " + name + " с логином: " + login + ". Его возраст: "
                + age + ". Все хобби:\n" + sb;
    }
}

