/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Windows 10 Version 2
 */
public class DBConnection {

    public Connection getConnection() throws Exception, SQLException {
        String url = "jdbc:sqlserver://" + serverName + ":" + portNumber + ";databaseName=" + dbName;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        System.out.println("Connected");
        return DriverManager.getConnection(url, userID, password);
    }

    private final String serverName = "localhost";
    private final String dbName = "SU18_WebLab_SushiRestaurant";
    private final String portNumber = "1433";
    private final String userID = "sa";
    private final String password = "sa";

    public static void main(String[] args) throws Exception {
        DBConnection db = new DBConnection();
        db.getConnection();

    }
}
