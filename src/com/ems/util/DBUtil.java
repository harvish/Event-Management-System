package com.ems.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

// TODO: Auto-generated Javadoc
/**
 * The Class DbUtil.
 */
public class DBUtil {

    /** The connection. */
    private static Connection connection = null;

    /**
     * Gets the connection.
     *
     * @return the connection
     * @throws ClassNotFoundException the class not found exception
     * @throws IOException Signals that an I/O exception has occurred.
     * @throws SQLException the sQL exception
     */
    public static Connection getConnection()throws  ClassNotFoundException, IOException, SQLException {
        
                Properties prop = new Properties();
                InputStream inputStream = DBUtil.class.getClassLoader().getResourceAsStream("/db.properties");
                prop.load(inputStream);
                String driver = prop.getProperty("driver");
                String url = prop.getProperty("url");
                String user = prop.getProperty("user");
                String password = prop.getProperty("password");
                Class.forName(driver);
    	    	Class.forName(driver);
                connection = DriverManager.getConnection(url, user, password);
        return connection;
    }
}
