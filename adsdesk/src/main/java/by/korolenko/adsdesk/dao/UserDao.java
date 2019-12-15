package by.korolenko.adsdesk.dao;

import by.korolenko.adsdesk.bean.User;
import by.korolenko.adsdesk.dao.exception.DaoException;

/**
 * @author Sergei Korolenko
 * @version 1.0
 */
public interface UserDao extends Dao<User> {

    User findByLoginAndPassword(String login, String password) throws DaoException;

    void register(User user) throws DaoException;

    void changePassword(String oldPassword, String newPassword) throws DaoException;
}
