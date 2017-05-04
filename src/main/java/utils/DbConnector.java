package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Igor Odokienko
 */
public class DbConnector {

    public static String DB_DRIVER = "com.mysql.jdbc.Driver";
    public static String dbUrl = PropertyConfig.getProperty("dbUrl");
    public static String dbUsername = PropertyConfig.getProperty("dbUsername");
    public static String dbPassword = PropertyConfig.getProperty("dbPassword");
    public static Connection connection = null;
    public static Statement statement = null;

    public static Connection initConnection() {
        try {
            Class.forName(DB_DRIVER);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("MySQL driver isn't found");
        }

        try {
            connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
            return connection;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static Statement getStatement(Connection con) {
        try {
            statement = con.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return statement;
    }

    public static void closeConnection(Connection con, Statement st) {
        try {
            if (con != null) {
                con.close();
            }
            if (st != null) {
                st.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
