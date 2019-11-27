package by.korolenko.adsdesk.dao.factory;

import by.korolenko.adsdesk.dao.TransactionFactory;
import by.korolenko.adsdesk.dao.pool.ConnectionPool;
import by.korolenko.adsdesk.dao.transaction.TransactionImpl;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 14.11.2019
 */
public class TransactionFactoryImpl implements TransactionFactory {

    private Connection connection;

    public TransactionFactoryImpl() {
        this.connection = ConnectionPool.getInstance().getConnection();
    }

    @Override
    public TransactionImpl createWrapperConnection() {
        return new TransactionImpl(connection);
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
