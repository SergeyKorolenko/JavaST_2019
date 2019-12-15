package by.korolenko.adsdesk.dao.mysqlimpl;

import by.korolenko.adsdesk.bean.Country;
import by.korolenko.adsdesk.bean.Region;
import by.korolenko.adsdesk.dao.AbstractDao;
import by.korolenko.adsdesk.dao.RegionDao;
import by.korolenko.adsdesk.dao.exception.DaoException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Sergei Korolenko
 * @version 1.0
 */
public class RegionDaoMySqlImpl extends AbstractDao implements RegionDao {

    private static final String SQL_FIND_BY_ID = "SELECT id, name, country_id" +
            " FROM  ads_desk.region WHERE id = ?";

    /**
     * This method returns an entity by id.
     *
     * @param id id
     * @return entity
     * @throws DaoException exception
     */
    @Override
    public Region findById(Integer id) throws DaoException {
        try (PreparedStatement statement =
                     connection.prepareStatement(SQL_FIND_BY_ID)) {
            statement.setString(1, id.toString());
            try (ResultSet resultSet = statement.executeQuery()) {
                Region region = new Region();
                while (resultSet.next()) {
                    region.setId(id);
                    region.setRegionName(resultSet.getString("name"));
                    Country country = new Country();
                    country.setId(resultSet.getInt("country_id"));
                    region.setCountry(country);
                }
                return region;
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

}
