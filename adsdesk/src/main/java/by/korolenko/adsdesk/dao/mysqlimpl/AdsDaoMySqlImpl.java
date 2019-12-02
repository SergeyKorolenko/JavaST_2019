package by.korolenko.adsdesk.dao.mysqlimpl;

import by.korolenko.adsdesk.bean.Ads;
import by.korolenko.adsdesk.bean.Category;
import by.korolenko.adsdesk.bean.Locality;
import by.korolenko.adsdesk.bean.User;
import by.korolenko.adsdesk.bean.enums.State;
import by.korolenko.adsdesk.dao.AbstractDao;
import by.korolenko.adsdesk.dao.AdsDao;
import by.korolenko.adsdesk.dao.exception.DaoException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 14.11.2019
 */
public class AdsDaoMySqlImpl extends AbstractDao implements AdsDao {

    private static final String SQL_READ_ALL_ADS = "SELECT id," +
            "heading, text, price, state, bargain, register_date, locality_id," +
            "category_id, user_id FROM ads_desk.ads";

    private static final String SQL_FIND_ADS_BY_CATEGORY_ID = "SELECT id," +
            "heading, text, price, state, bargain, register_date, locality_id," +
            "category_id, user_id FROM ads_desk.ads WHERE category_id = ?";

    private static final String SQL_FIND_BY_ID = "SELECT id," +
            "heading, text, price, state, bargain, register_date, locality_id," +
            "category_id, user_id FROM ads_desk.ads WHERE id = ?";

    /**
     * This method returns an entity by id.
     *
     * @param id id
     * @return entity
     * @throws DaoException exception
     */
    @Override
    public Ads findById(Integer id) throws DaoException {
        try (PreparedStatement statement =
                     connection.prepareStatement(SQL_FIND_BY_ID)) {
            statement.setString(1, id.toString());
            try (ResultSet resultSet = statement.executeQuery()) {
                Ads ads = new Ads();
                while (resultSet.next()) {
                    ads.setId(id);
                    ads.setHeading(resultSet.getString("heading"));
                    ads.setText(resultSet.getString("text"));
                    ads.setPrice(resultSet.getDouble("price"));
                    ads.setStatus(State.getById(resultSet.getInt("state")));
                    ads.setBargain(State.getById(resultSet.getInt("bargain")));
                    ads.setRegisterDate(resultSet.getDate("register_date"));
                    Category category = new Category();
                    category.setId(resultSet.getInt("category_id"));
                    ads.setCategory(category);
                    Locality locality = new Locality();
                    locality.setId(resultSet.getInt("locality_id"));
                    ads.setLocality(locality);
                    User user = new User();
                    user.setId(resultSet.getInt("user_id"));
                    ads.setUser(user);
                }
                return ads;
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    /**
     * This method deletes an entity by id.
     *
     * @param id id
     * @throws DaoException exception
     */
    @Override
    public void delete(Integer id) throws DaoException {

    }

    /**
     * This method adds an entity to the database.
     *
     * @param entity entity
     * @throws DaoException exception
     */
    @Override
    public void create(Ads entity) throws DaoException {

    }

    /**
     * This method updates an entity.
     *
     * @param entity entity
     * @throws DaoException exception
     */
    @Override
    public void update(Ads entity) throws DaoException {
    }

    @Override
    public List<Ads> readAll() throws DaoException {
        try (PreparedStatement statement = connection.
                prepareStatement(SQL_READ_ALL_ADS); ResultSet resultSet =
                     statement.executeQuery()) {
            List<Ads> adsList = new ArrayList<>();
            while (resultSet.next()) {
                Ads ads = new Ads();
                ads.setId(resultSet.getInt("id"));
                ads.setHeading(resultSet.getString("heading"));
                ads.setText(resultSet.getString("text"));
                ads.setPrice(resultSet.getDouble("price"));
                ads.setStatus(State.getById(resultSet.getInt("state")));
                ads.setBargain(State.getById(resultSet.getInt("bargain")));
                ads.setRegisterDate(resultSet.getDate("register_date"));
                Category category = new Category();
                category.setId(resultSet.getInt("category_id"));
                ads.setCategory(category);
                Locality locality = new Locality();
                locality.setId(resultSet.getInt("locality_id"));
                ads.setLocality(locality);
                User user = new User();
                user.setId(resultSet.getInt("user_id"));
                ads.setUser(user);
                adsList.add(ads);
            }
            return adsList;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public List<Ads> findByCategory(Integer categoryId) throws DaoException {
        try (PreparedStatement statement = connection.
                prepareStatement(SQL_FIND_ADS_BY_CATEGORY_ID)) {
            statement.setString(1, categoryId.toString());
            try (ResultSet resultSet = statement.executeQuery()) {
                List<Ads> adsList = new ArrayList<>();
                while (resultSet.next()) {
                    Ads ads = new Ads();
                    ads.setId(resultSet.getInt("id"));
                    ads.setHeading(resultSet.getString("heading"));
                    ads.setText(resultSet.getString("text"));
                    ads.setPrice(resultSet.getDouble("price"));
                    ads.setStatus(State.getById(resultSet.getInt("state")));
                    ads.setBargain(State.getById(resultSet.getInt("bargain")));
                    ads.setRegisterDate(resultSet.getDate("register_date"));
                    Category category = new Category();
                    category.setId(categoryId);
                    ads.setCategory(category);
                    Locality locality = new Locality();
                    locality.setId(resultSet.getInt("locality_id"));
                    ads.setLocality(locality);
                    User user = new User();
                    user.setId(resultSet.getInt("user_id"));
                    ads.setUser(user);
                    adsList.add(ads);
                }
                return adsList;
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }
}
