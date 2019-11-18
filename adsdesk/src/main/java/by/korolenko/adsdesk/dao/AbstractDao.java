package by.korolenko.adsdesk.dao;

import java.sql.Connection;

abstract public class AbstractDao {

    protected Connection connection;

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public Connection getConnection() {
        return connection;
    }
}
