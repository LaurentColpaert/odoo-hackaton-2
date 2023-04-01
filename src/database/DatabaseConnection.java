package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static DatabaseConnection instance;
    private Connection connection;
    private String url = "jdbc:sqlite:"+System.getProperty("user.dir")+"/db/little_step.db";

    private DatabaseConnection() throws SQLException{
        this.connection = DriverManager.getConnection(url);
    }

    public Connection getConnection() {
        return connection;
    }

    public static DatabaseConnection getInstance() throws SQLException{
        if (instance == null){
            instance = new DatabaseConnection();
        }else if (instance.getConnection().isClosed()){
            instance = new DatabaseConnection();
        }
        return instance;
    }
}
