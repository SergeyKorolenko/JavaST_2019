package by.korolenko.adsdesk.dao.mysqlimpl;

import by.korolenko.adsdesk.bean.User;
import by.korolenko.adsdesk.dao.AbstractDao;
import by.korolenko.adsdesk.dao.UserDao;

import java.sql.SQLException;
import java.util.List;

public class UserDaoMySqlImpl extends AbstractDao implements UserDao {

    @Override
    public List<User> findAll() throws SQLException {
        return null;
    }

    @Override
    public User findEntityById(Integer id) throws SQLException {
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
    public void create(User entity) throws SQLException {
    }

    /**
     * This method updates an entity.
     *
     * @param entity entity
     * @throws SQLException exception
     */
    @Override
    public void update(User entity) throws SQLException {
    }
}
