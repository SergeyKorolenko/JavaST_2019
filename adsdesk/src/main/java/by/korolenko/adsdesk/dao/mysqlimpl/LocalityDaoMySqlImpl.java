package by.korolenko.adsdesk.dao.mysqlimpl;

import by.korolenko.adsdesk.bean.Locality;
import by.korolenko.adsdesk.bean.Region;
import by.korolenko.adsdesk.dao.AbstractDao;
import by.korolenko.adsdesk.dao.LocalityDao;
import by.korolenko.adsdesk.dao.exception.DaoException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Sergei Korolenko
 * @version 1.0
 */
public class LocalityDaoMySqlImpl extends AbstractDao implements LocalityDao {

    private static final String SQL_FIND_BY_ID = "SELECT id, name, region_id " +
            "FROM locality WHERE id = ?";

    private static final String SQL_READ_ALL = "SELECT id, name, region_id " +
            "FROM locality";

    /**
     * This method returns an entity by id.
     *
     * @param id id
     * @return entity
     * @throws DaoException exception
     */
    @Override
    public Locality findById(Integer id) throws DaoException {
        try (PreparedStatement statement =
                     connection.prepareStatement(SQL_FIND_BY_ID)) {
            statement.setString(1, id.toString());
            try (ResultSet resultSet = statement.executeQuery()) {
                Locality locality = new Locality();
                if (resultSet.next()) {
                    locality.setId(id);
                    locality.setLocalityName(resultSet.getString("name"));
                    Region region = new Region();
                    region.setId(resultSet.getInt("region_id"));
                    locality.setRegion(region);
                }
                return locality;
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public List<Locality> readAll() throws DaoException {
        try (PreparedStatement statement =
                     connection.prepareStatement(SQL_READ_ALL);
             ResultSet resultSet = statement.executeQuery()) {
            List<Locality> localities = new ArrayList<>();
            while (resultSet.next()) {
                Locality locality = new Locality();
                locality.setId(resultSet.getInt("id"));
                locality.setLocalityName(resultSet.getString("name"));
                Region region = new Region();
                region.setId(resultSet.getInt("region_id"));
                locality.setRegion(region);
                localities.add(locality);
            }
            return localities;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }
}
