package by.korolenko.adsdesk.dao.mysqlimpl;

import by.korolenko.adsdesk.bean.Locality;
import by.korolenko.adsdesk.dao.AbstractDao;
import by.korolenko.adsdesk.dao.LocalityDao;

import java.sql.SQLException;
import java.util.List;

public class LocalityDaoMySqlImpl extends AbstractDao implements LocalityDao {
    @Override
    public List<Locality> findAll() throws SQLException {
        return null;
    }

    @Override
    public Locality findEntityById(Integer id) throws SQLException {
        return null;
    }

    @Override
    public void delete(Integer id) throws SQLException {
    }

    @Override
    public void create(Locality entity) throws SQLException {
    }

    @Override
    public void update(Locality entity) throws SQLException {
    }
}
