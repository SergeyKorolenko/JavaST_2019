package by.korolenko.adsdesk.dao.factory;

import by.korolenko.adsdesk.dao.TransactionFactory;
import by.korolenko.adsdesk.dao.pool.ConnectionPool;
import by.korolenko.adsdesk.dao.transaction.TransactionImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author Sergei Korolenko
 * @version 1.0
 */
public class TransactionFactoryImpl implements TransactionFactory {

    private static final Logger LOGGER = LogManager.getLogger();

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
            LOGGER.debug("Error of connection closing", e);
        }
    }
}
