package by.korolenko.adsdesk.dao.mysqlimpl;

import by.korolenko.adsdesk.bean.User;
import by.korolenko.adsdesk.bean.enums.Role;
import by.korolenko.adsdesk.dao.AbstractDao;
import by.korolenko.adsdesk.dao.UserDao;
import by.korolenko.adsdesk.dao.exception.DaoException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 14.11.2019
 */
public class UserDaoMySqlImpl extends AbstractDao implements UserDao {

    private static final String SQL_FIND_BY_LOGIN_ADN_PASSWORD =
            "SELECT `id`, `role` FROM `ads_desk`.`user`" +
                    "WHERE `login` = ? AND `password` = ?";

    /**
     * This method returns an entity by id.
     *
     * @param id id
     * @return entity
     * @throws DaoException exception
     */
    @Override
    public User findById(Integer id) throws DaoException {
        return null;
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
    public void create(User entity) throws DaoException {

    }

    /**
     * This method updates an entity.
     *
     * @param entity entity
     * @throws DaoException exception
     */
    @Override
    public void update(User entity) throws DaoException {

    }

    @Override
    public User findByLoginAndPassword(String login, String password)
            throws DaoException {
        try (PreparedStatement statement = connection.
                prepareStatement(SQL_FIND_BY_LOGIN_ADN_PASSWORD)) {
            statement.setString(1, login);
            statement.setString(2, password);
            try (ResultSet resultSet = statement.executeQuery()) {
                User user = null;
                while (resultSet.next()) {
                    user = new User();
                    user.setId(resultSet.getInt("id"));
                    user.setLogin(login);
                    user.setPassword(password);
                    user.setRole(Role.getById(resultSet.
                            getInt("role")));
                }
                return user;
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }
}
