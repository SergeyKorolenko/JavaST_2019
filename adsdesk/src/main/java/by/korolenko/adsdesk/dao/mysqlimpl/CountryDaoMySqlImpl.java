package by.korolenko.adsdesk.dao.mysqlimpl;

import by.korolenko.adsdesk.bean.Country;
import by.korolenko.adsdesk.dao.AbstractDao;
import by.korolenko.adsdesk.dao.CountryDao;

import java.sql.SQLException;
import java.util.List;

public class CountryDaoMySqlImpl extends AbstractDao implements CountryDao {
    @Override
    public List<Country> findAll() throws SQLException {
        return null;
    }

    @Override
    public Country findEntityById(Integer id) throws SQLException {
        return null;
    }

    @Override
    public void delete(Integer id) throws SQLException {
    }

    /**
     * This method adds an entity to database.
     *
     * @param entity entity
     * @throws SQLException exception
     */
    @Override
    public void create(Country entity) throws SQLException {

    }

    @Override
    public void update(Country entity) throws SQLException {
    }
}
