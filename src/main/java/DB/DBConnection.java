package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {

    private Connection connection;
    private static DBConnection dbConnection;

    String URL = "jdbc:mysql://localhost/thogakade";

    static Properties props = new Properties();

    static {
        props.setProperty("user","root");
        props.setProperty("password","80221474");
    }

    private DBConnection() throws SQLException {
        connection = DriverManager.getConnection(URL, props);
    }

    public static DBConnection getInstance() throws SQLException {
        if (dbConnection == null) {
            return dbConnection = new DBConnection();
        } else {
           return dbConnection;
        }
    }

    public Connection getConnection(){
        return connection;
    }

}
