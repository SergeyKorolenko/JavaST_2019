package by.korolenko.adsdesk.dao.wrapper;

import by.korolenko.adsdesk.bean.enums.EntityType;
import by.korolenko.adsdesk.dao.AbstractDao;
import by.korolenko.adsdesk.dao.WrapperConnection;
import by.korolenko.adsdesk.dao.mysqlimpl.*;

import java.sql.Connection;

public class WrapperConnectionImpl implements WrapperConnection {

    private Connection connection;

    public WrapperConnectionImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public AbstractDao createDao(EntityType entityType) {

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
        return dao;
    }
}
