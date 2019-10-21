package laba1.com.persistence;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.apache.log4j.Logger;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;


public class DataSourceFactory {
    public static final String DB_PROPERTIES = "/db.properties";
    public static final String DB_URL = "DB_URL";
    public static final String DB_USERNAME = "DB_USERNAME";
    public static final String DB_PASSWORD = "DB_PASSWORD";
    private static final Logger LOG = Logger.getLogger(DataSourceFactory.class);
    private static final DataSourceFactory INSTANCE = new DataSourceFactory();
    private static DataSource dataSource;

    static {
        Properties properties = new Properties();
        try {
            properties.load(DataSourceFactory.class.getResourceAsStream(DB_PROPERTIES));
            MysqlDataSource mysqlDataSource = new MysqlDataSource();
            mysqlDataSource.setUrl(properties.getProperty(DB_URL));
            mysqlDataSource.setUser(properties.getProperty(DB_USERNAME));
            mysqlDataSource.setPassword(properties.getProperty(DB_PASSWORD));
            dataSource = mysqlDataSource;
            LOG.info("DataSource created: " + dataSource);
        } catch (IOException e) {
            LOG.error("Error occured while reading properties from file.", e);
        }
    }

    private DataSourceFactory() {
    }

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            LOG.error("Error occured while connection creating.", e);
        }
        return connection;
    }

    public static PreparedStatement getPreparedStatement(String query) throws SQLException {
        return getConnection().prepareStatement(query);
    }
}
