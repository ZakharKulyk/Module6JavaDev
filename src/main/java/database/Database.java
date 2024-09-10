package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static Database instance = null;
    private Connection connection = null;


    private Database() {

    }


    private void initDb() {



        String URL = "jdbc:mysql://127.0.0.1:3306/test";
        String PASSWORD = "Zakhar2005";
        String USER = "root";

        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException("Failed to connect");
        }
        System.out.println("Connection completed");
    }

    public static Database getInstance() throws SQLException {
        if (instance == null || instance.getConnection().isClosed()) {
            instance = new Database();
            instance.initDb();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
}
