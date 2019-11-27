package by.korolenko.adsdesk.service.impl;

import by.korolenko.adsdesk.bean.User;
import by.korolenko.adsdesk.bean.enums.EntityType;
import by.korolenko.adsdesk.dao.UserDao;
import by.korolenko.adsdesk.dao.exception.DaoException;
import by.korolenko.adsdesk.service.AbstractService;
import by.korolenko.adsdesk.service.UserService;
import by.korolenko.adsdesk.service.exception.ServiceException;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 14.11.2019
 */
public class UserServiceImpl extends AbstractService implements UserService {
    @Override
    public User findByLoginAndPassword(String login, String password)
            throws ServiceException {
        UserDao userDao = transaction.createDao(EntityType.USER);
        try {
            User user = userDao.findByLoginAndPassword(login, password);
            return user;
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }
}
