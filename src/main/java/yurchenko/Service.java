package yurchenko;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Service {
    private static Logger log = LoggerFactory.getLogger(Service.class);
    private static final String DB_URL = "jdbc:postgresql://localhost/postgres";
    private static final String DB_USER = "postgres";
    private static final String DB_PASSWORD = "";
    private static Connection connection;
    private static ResultSet resultSet;
    private static PreparedStatement preparedStatement;

    public void connect() {
        try {
            connection = DriverManager.getConnection(DB_URL,
                    DB_USER, DB_PASSWORD);
        } catch (SQLException e) {
            log.info("Can't connect to Postgres {}", e.getMessage());
        }
    }

    public static void search(String title) {
        try {
            List<String> searchList = new ArrayList<>();
            preparedStatement = connection.prepareStatement("SELECT * FROM products WHERE title LIKE '%" + title + "%';");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String string = "";
                for (int i = 1; i < 8; i++) {
                    string = string.concat(resultSet.getString(i).concat(" | "));
                }
                searchList.add(string);
            }
            System.out.println(searchList);
        } catch (SQLException e) {
            log.info("Can't search by title {}", e.getMessage());
        }
    }

    public static void update(String title, int productId) {
        try {
            preparedStatement = connection.prepareStatement("UPDATE products SET title = ? WHERE prod_id = ?;");
            preparedStatement.setString(1, title);
            preparedStatement.setInt(2, productId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            log.info("Can't update data {}", e.getMessage());
        }
    }

    public void delete(int productId) {
        try {
            preparedStatement = connection.prepareStatement("DELETE FROM products WHERE prod_id = ?;");
            preparedStatement.setInt(1, productId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            log.info("Can't delete entry {}", e.getMessage());
        }
    }

    public static void insert(String title) {
        try {
            preparedStatement = connection.prepareStatement("INSERT INTO products (" +
                    "category, title, actor, price, special, common_prod_id) VALUES " +
                    "(?,?,?,?,?,?);");
            preparedStatement.setInt(1, 1);
            preparedStatement.setString(2, title);
            preparedStatement.setString(3, "Tony Stark");
            preparedStatement.setFloat(4, (float) 9.99);
            preparedStatement.setShort(5, (short) 2);
            preparedStatement.setInt(6, 999);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            log.info("Can't insert into db {}", e.getMessage());
        }
    }

    public void disconnect() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            log.info("Disconnection error {}", e.getMessage());
        }
    }
}
