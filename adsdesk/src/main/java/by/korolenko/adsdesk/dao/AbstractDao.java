package by.korolenko.adsdesk.dao;

import java.sql.Connection;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 14.11.2019
 */
abstract public class AbstractDao {

    protected Connection connection;

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public Connection getConnection() {
        return connection;
    }
}
