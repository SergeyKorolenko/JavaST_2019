package by.korolenko.adsdesk.dao.pool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

public final class ConnectionPool {

    private static ConnectionPool instance;
    private static ReentrantLock locker = new ReentrantLock();
    private static AtomicBoolean flag = new AtomicBoolean(false);
    private BlockingQueue<ProxyConnection> freeConnection =
            new LinkedBlockingQueue<>();
    private BlockingQueue<ProxyConnection> usedConnection =
            new LinkedBlockingQueue<>();
    private DbDataConnection dataConnection = new DbDataConnection();

    private ConnectionPool() {
        init();
    }

    private void init() {
        try {
            Class.forName(dataConnection.getDriver());
            for (int i = 0; i < dataConnection.getPoolSize(); i++) {
                freeConnection.put(new ProxyConnection(createConnection()));
            }
        } catch (ClassNotFoundException | InterruptedException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static ConnectionPool getInstance() {
        if (!flag.get()) {
            try {
                locker.lock();
                if (instance == null) {
                    instance = new ConnectionPool();
                    flag.set(true);
                }
            } finally {
                locker.unlock();
            }
        }
        return instance;
    }

    public Connection getConnection() {
        ProxyConnection connection = null;
        try {
            locker.lock();
            connection = freeConnection.take();
            usedConnection.put(connection);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            locker.unlock();
        }
        return connection;
    }

    private ProxyConnection createConnection() throws SQLException {
        return new ProxyConnection(DriverManager.getConnection(dataConnection.getUrl(),
                dataConnection.getUser(), dataConnection.getPassword()));
    }

    public void returnConnection(Connection connection) {
        if (connection instanceof ProxyConnection) {
            ProxyConnection proxyConnection = (ProxyConnection) connection;
            usedConnection.remove(proxyConnection);
            try {
                freeConnection.put(proxyConnection);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void closePool() {
        try {
            for (int i = 0; i < freeConnection.size(); i++) {
                freeConnection.take().reallyClose();
            }
        } catch (InterruptedException | SQLException e) {
            Thread.currentThread().interrupt();
        }
    }
}
