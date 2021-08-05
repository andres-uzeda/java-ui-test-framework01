package Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
    /**
     * Method that connects to DB it initialized null in order to use try catch
     * @param url
     * @param login
     * @param password
     * @param dbname
     * @return Conection
     */
    public static Connection getConnection(String url, String login, String password, String dbname) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url + dbname, login, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
