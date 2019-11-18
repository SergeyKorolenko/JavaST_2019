package by.korolenko.adsdesk.dao.mysqlimpl;

import by.korolenko.adsdesk.bean.Ads;
import by.korolenko.adsdesk.dao.AbstractDao;
import by.korolenko.adsdesk.dao.AdsDao;

import java.sql.SQLException;
import java.util.List;

public class AdsDaoMySqlImpl extends AbstractDao implements AdsDao {
    @Override
    public List<Ads> findAll() throws SQLException {
        return null;
    }

    @Override
    public Ads findEntityById(Integer id) throws SQLException {
        return null;
    }

    @Override
    public void delete(Integer id) throws SQLException {
    }

    @Override
    public void create(Ads entity) throws SQLException {
    }

    @Override
    public void update(Ads entity) throws SQLException {
    }
}
