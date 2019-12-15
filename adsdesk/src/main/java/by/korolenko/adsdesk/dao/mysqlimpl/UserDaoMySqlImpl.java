package by.korolenko.adsdesk.dao.mysqlimpl;

import by.korolenko.adsdesk.bean.Locality;
import by.korolenko.adsdesk.bean.User;
import by.korolenko.adsdesk.bean.enums.Role;
import by.korolenko.adsdesk.bean.enums.State;
import by.korolenko.adsdesk.dao.AbstractDao;
import by.korolenko.adsdesk.dao.UserDao;
import by.korolenko.adsdesk.dao.exception.DaoException;

import java.sql.*;

/**
 * @author Sergei Korolenko
 * @version 1.0
 */
public class UserDaoMySqlImpl extends AbstractDao implements UserDao {

    private static final String SQL_FIND_BY_LOGIN_ADN_PASSWORD =
            "SELECT id, role, name FROM ads_desk.user " +
                    "WHERE login = ? AND password = ?";

    private static final String SQL_FIND_BY_ID = "SELECT id, login, password," +
            "role, name, surname, patronymic, phone, register_date, status," +
            "email, avatar_url, locality_id FROM ads_desk.user WHERE id = ?";

    private static final String SQL_REGISTER = "INSERT INTO ads_desk.user (login, password, role, name, phone, register_date, status, email) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

    private static final String SQL_CHANGE_PASSWORD = "UPDATE ads_desk.user SET password = ? WHERE password = ?";
    /**
     * This method returns an entity by id.
     *
     * @param id id
     * @return entity
     * @throws DaoException exception
     */
    @Override
    public User findById(Integer id) throws DaoException {
        try (PreparedStatement statement =
                     connection.prepareStatement(SQL_FIND_BY_ID)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                User user = new User();
                while (resultSet.next()) {
                    user.setId(id);
                    user.setLogin(resultSet.getString("login"));
                    user.setPassword(resultSet.getString("password"));
                    user.setRole(Role.getById(resultSet.getInt("role")));
                    user.setName(resultSet.getString("name"));
                    user.setSurname(resultSet.getString("surname"));
                    user.setPatronymic(resultSet.getString("patronymic"));
                    user.setPhone(resultSet.getLong("phone"));
                    user.setRegisterDate(resultSet.getDate("register_date"));
                    user.setStatus(State.getById(resultSet.getInt("status")));
                    user.setEmail(resultSet.getString("email"));
                    user.setAvatarUrl(resultSet.getString("avatar_url"));
                    Locality locality = new Locality();
                    locality.setId(resultSet.getInt("locality_id"));
                    user.setLocality(locality);
                }
                return user;
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
                    user.setName(resultSet.getString("name"));
                }
                return user;
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public void register(User user) throws DaoException {
        try (PreparedStatement statement = connection.prepareStatement(SQL_REGISTER)) {
            statement.setString(1, user.getLogin());
            statement.setString(2, user.getPassword());
            statement.setInt(3, user.getRole().getId());
            statement.setString(4, user.getName());
            statement.setLong(5, user.getPhone());
            statement.setDate(6, new Date(user.getRegisterDate().getTime()));
            statement.setInt(7, user.getStatus().getId());
            statement.setString(8, user.getEmail());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public void changePassword(String oldPassword, String newPassword) throws DaoException {
        try (PreparedStatement statement = connection.prepareStatement(SQL_CHANGE_PASSWORD)) {
            statement.setString(1, newPassword);
            statement.setString(2, oldPassword);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }
}
