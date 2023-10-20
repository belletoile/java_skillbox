package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DB {
    private final String HOST = "localhost";
    private final String PORT = "8889";
    private final String DB_NAME = "java_db";
    private final String LOGIN = "root";
    private final String PASS = "root";

    private Connection dbConn = null;

    private Connection getDbConnection() throws ClassNotFoundException, SQLException {
        String connStr = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DB_NAME;
        Class.forName("com.mysql.cj.jdbc.Driver");

        dbConn = DriverManager.getConnection(connStr, LOGIN, PASS);
        return dbConn;
    }

    public void isConnected() throws SQLException, ClassNotFoundException {
        dbConn = getDbConnection();
        System.out.println(dbConn.isValid(1000));
    }

    public void createTableUser(String tableName) throws SQLException, ClassNotFoundException {
        String sql = "CREATE TABLE IF NOT EXISTS " + tableName +
                " (id INT AUTO_INCREMENT PRIMARY KEY, login VARCHAR(50), password VARCHAR(100))"
                + " ENGINE=MYISAM;";

        Statement statement = getDbConnection().createStatement();
        statement.executeUpdate(sql);
    }

    public void createTableItems(String tableName) throws SQLException, ClassNotFoundException {
        String sql = "CREATE TABLE IF NOT EXISTS " + tableName +
                " (id INT AUTO_INCREMENT PRIMARY KEY, title VARCHAR(255), price INT, category VARCHAR(255))"
                + " ENGINE=MYISAM;";

        Statement statement = getDbConnection().createStatement();
        statement.executeUpdate(sql);
    }

    public void createTableOrders(String tableName) throws SQLException, ClassNotFoundException {
        String sql = "CREATE TABLE IF NOT EXISTS " + tableName +
                " (id INT AUTO_INCREMENT PRIMARY KEY, user_id INT, items_id INT) ENGINE=MYISAM;";

        Statement statement = getDbConnection().createStatement();
        statement.executeUpdate(sql);
    }

    public void insertSomethingUser(String table, String login, String password)
            throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO " + table + " (login, password) VALUES (?, ?)";

        PreparedStatement prSt = getDbConnection().prepareStatement(sql);
        prSt.setString(1, login);
        prSt.setString(2, password);

        prSt.executeUpdate();
    }

    public void insertSomethingItems(String table, String title, String price, String category)
            throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO " + table + " (title, price, category) VALUES (?, ?, ?)";

        PreparedStatement prSt = getDbConnection().prepareStatement(sql);
        prSt.setString(1, title);
        prSt.setString(2, price);
        prSt.setString(3, category);

        prSt.executeUpdate();
    }

    public void insertSomethingOrder(String table, String user_id, String items_id)
            throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO " + table + " (user_id, items_id) VALUES (?, ?)";

        PreparedStatement prSt = getDbConnection().prepareStatement(sql);
        prSt.setString(1, user_id);
        prSt.setString(2, items_id);

        prSt.executeUpdate();
    }

    public String getArticlesUserByLogin(String table) throws SQLException, ClassNotFoundException {
        String user_id = null;
        String sql = "SELECT * FROM " + table + " WHERE `login` = 'john'";

        Statement statement = getDbConnection().createStatement();
        ResultSet res = statement.executeQuery(sql);
        while (res.next()) {
            user_id = res.getString("id");
        }
        return user_id;
    }

    public void getArticlesOrders() throws SQLException, ClassNotFoundException {

        String sql = "SELECT orders.id, users.login, items.title " +
                "FROM orders " +
                "JOIN users ON orders.user_id = users.id " +
                "JOIN items ON orders.items_id = items.id";
        Statement statement = getDbConnection().createStatement();
        ResultSet res = statement.executeQuery(sql);

        while (res.next()) {
            String userLogin = res.getString("login");
            String itemName = res.getString("title");
            System.out.println(userLogin + " - " + itemName);
        }
    }

    public List<String> getArticlesUserByCategory(String table) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM " + table + " WHERE `category` = 'hats'";

        Statement statement = getDbConnection().createStatement();
        ResultSet res = statement.executeQuery(sql);

        List<String> itemIdList = new ArrayList<>();

        while (res.next()) {
            String itemId = res.getString("id");
            itemIdList.add(itemId);
        }
        return itemIdList;
    }

    public void deleteSomething() throws SQLException, ClassNotFoundException {
//        String sql = "DELETE FROM `articles` WHERE `id` = 4";
        String sql = "DROP TABLE `orders` ";

        Statement statement = getDbConnection().createStatement();
        statement.executeUpdate(sql);
    }
}
