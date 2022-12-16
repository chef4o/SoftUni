package dbConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DbConnection {

    private static final String CONNECTION_STRING = "jdbc:mysql://localhost:3306/";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Lxile101e12.";

    private String url;
    private Properties properties;

    public DbConnection(String dbName) {
        this.setProperties();
        this.setUrl(dbName);
    }

    private void setUrl(String dbName) {
        this.url = CONNECTION_STRING + dbName;
    }

    private void setProperties() {
        this.properties = new Properties();
        this.properties.setProperty("user", USERNAME);
        this.properties.setProperty("password", PASSWORD);
    }

    public Connection getConnection () throws SQLException {
        return DriverManager.getConnection(this.url, this.properties);
    }
}
