package org.example;


import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        DB db = new DB();
        try {
//            Создаем таблицу и заполняем данными
            db.createTableUser("users");
            db.insertSomethingUser("users","john", "some_pass");
            db.insertSomethingUser("users","alex", "some_pass");
//            Создаем таблицу и заполняем данными
            db.createTableItems("items");
            db.insertSomethingItems("items","Кружка Мужская", "300","cups");
            db.insertSomethingItems("items","Кепка красная", "150","hats");
            db.insertSomethingItems("items","Кепка синяя", "200","hats");
            db.insertSomethingItems("items","Кружка Женская", "200","cups");
            db.insertSomethingItems("items","Красная футболка", "550","shirts");
            db.insertSomethingItems("items","Футболка 'Рик и Морти'", "700","shirts");
//            Создаем таблицу
            db.createTableOrders("orders");
            String user_id = db.getArticlesUserByLogin("users");
            List<String> items_id = db.getArticlesUserByCategory("items");

            db.insertSomethingOrder("orders", user_id, items_id.get(0));
            db.insertSomethingOrder("orders", user_id, items_id.get(1));

            db.getArticlesOrders();
//            db.deleteSomething();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}