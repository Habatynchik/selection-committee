package ua.epam.elearn.selection.committee.model.dao.database;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class DBManager {
    private static DBManager instance;
    private final HikariDataSource dataSource;

    private DBManager() {
        Properties properties = getProps();
        HikariConfig config = new HikariConfig();

        config.setDriverClassName(properties.getProperty("driver"));

        config.setJdbcUrl(properties.getProperty("url"));
        config.setUsername(properties.getProperty("user"));
        config.setPassword(properties.getProperty("password"));

       // config.setMaximumPoolSize(10);

        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");

        dataSource = new HikariDataSource(config);

    }
    public static synchronized DBManager getInstance() {

        if (instance == null) {
            instance = new DBManager();
        }
        return instance;
    }
    private Properties getProps() {
        Properties properties = new Properties();

        try {
            properties.load(DBManager.class.getResourceAsStream("/database.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return properties;
    }

    public Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    public void closeConnection(){
        dataSource.close();
    }

}
