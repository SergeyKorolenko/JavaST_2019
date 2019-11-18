package by.korolenko.adsdesk.dao.factory;

import by.korolenko.adsdesk.dao.WrapperConnectionFactory;
import by.korolenko.adsdesk.dao.pool.ConnectionPool;
import by.korolenko.adsdesk.dao.wrapper.WrapperConnectionImpl;

import java.sql.Connection;
import java.sql.SQLException;

public class WrapperConnectionFactoryImpl implements WrapperConnectionFactory {

    private Connection connection;

    public WrapperConnectionFactoryImpl() {
        this.connection = ConnectionPool.getInstance().getConnection();
    }

    @Override
    public WrapperConnectionImpl createWrapperConnection() {
        return new WrapperConnectionImpl(connection);
    }

    @Override
    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
