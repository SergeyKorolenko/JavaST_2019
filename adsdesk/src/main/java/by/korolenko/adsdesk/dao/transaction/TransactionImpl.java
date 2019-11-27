package by.korolenko.adsdesk.dao.transaction;

import by.korolenko.adsdesk.bean.enums.EntityType;
import by.korolenko.adsdesk.dao.AbstractDao;
import by.korolenko.adsdesk.dao.Transaction;
import by.korolenko.adsdesk.dao.mysqlimpl.*;

import java.sql.Connection;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 14.11.2019
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
            case COUNTRY:
                dao = new CountryDaoMySqlImpl();
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
        dao.setConnection(connection);
        return (T) dao;
    }
}
