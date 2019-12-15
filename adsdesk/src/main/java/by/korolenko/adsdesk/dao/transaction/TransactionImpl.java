package by.korolenko.adsdesk.dao.transaction;

import by.korolenko.adsdesk.bean.enums.EntityType;
import by.korolenko.adsdesk.dao.AbstractDao;
import by.korolenko.adsdesk.dao.Transaction;
import by.korolenko.adsdesk.dao.exception.DaoException;
import by.korolenko.adsdesk.dao.mysqlimpl.*;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author Sergei Korolenko
 * @version 1.0
 */
public class TransactionImpl implements Transaction {

    private Connection connection;

    public TransactionImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public <T extends AbstractDao> T createDao(EntityType entityType) {

        AbstractDao dao = null;
        switch (entityType) {
            case LOCALITY:
                dao = new LocalityDaoMySqlImpl();
                break;
            case CATEGORY:
                dao = new CategoryDaoMySqlImpl();
                break;
            case COMMENT:
                dao = new CommentDaoMySqlImpl();
                break;
            case REGION:
                dao = new RegionDaoMySqlImpl();
                break;
            case IMAGE:
                dao = new ImageDaoMySqlImpl();
                break;
            case USER:
                dao = new UserDaoMySqlImpl();
                break;
            case ADS:
                dao = new AdsDaoMySqlImpl();
                break;
        }
        if (dao != null) {
            dao.setConnection(connection);
        }
        return (T) dao;
    }

    @Override
    public void commit() throws DaoException {
        try {
            connection.commit();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public void rollback() throws DaoException {
        try {
            connection.rollback();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }
}
