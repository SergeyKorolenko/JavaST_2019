package by.korolenko.adsdesk.dao.mysqlimpl;

import by.korolenko.adsdesk.bean.Region;
import by.korolenko.adsdesk.dao.AbstractDao;
import by.korolenko.adsdesk.dao.RegionDao;

import java.sql.SQLException;
import java.util.List;

public class RegionDaoMySqlImpl extends AbstractDao implements RegionDao {
    @Override
    public List<Region> findAll() throws SQLException {
        return null;
    }

    @Override
    public Region findEntityById(Integer id) throws SQLException {
        return null;
    }

    @Override
    public void delete(Integer id) throws SQLException {
    }

    @Override
    public void create(Region entity) throws SQLException {
    }

    @Override
    public void update(Region entity) throws SQLException {
    }
}
