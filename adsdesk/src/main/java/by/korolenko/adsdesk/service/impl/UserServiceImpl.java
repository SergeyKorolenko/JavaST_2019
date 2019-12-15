package by.korolenko.adsdesk.service.impl;

import by.korolenko.adsdesk.bean.User;
import by.korolenko.adsdesk.bean.enums.EntityType;
import by.korolenko.adsdesk.bean.enums.Role;
import by.korolenko.adsdesk.bean.enums.State;
import by.korolenko.adsdesk.dao.UserDao;
import by.korolenko.adsdesk.dao.exception.DaoException;
import by.korolenko.adsdesk.service.AbstractService;
import by.korolenko.adsdesk.service.UserService;
import by.korolenko.adsdesk.service.exception.ServiceDataException;
import by.korolenko.adsdesk.service.exception.ServiceException;
import by.korolenko.adsdesk.service.validator.UserDataValidator;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Date;

/**
 * @author Sergei Korolenko
 * @version 1.0
 */
public class UserServiceImpl extends AbstractService implements UserService {

    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public User findById(Integer id) throws ServiceException {
        UserDao userDao = transaction.createDao(EntityType.USER);
        try {
            return userDao.findById(id);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public User findByLoginAndPassword(String login, String password)
            throws ServiceException {
        UserDao userDao = transaction.createDao(EntityType.USER);
        try {
            String sha256hex = createHash(password);
            return userDao.findByLoginAndPassword(login, sha256hex);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void register(User user) throws ServiceException {
        UserDao userDao = transaction.createDao(EntityType.USER);
        UserDataValidator validator = new UserDataValidator();
        try {
            if (!validator.isLogin(user.getLogin())) {
                throw new ServiceDataException("invalid login");
            }
            if (!validator.isFIO(user.getName())) {
                throw new ServiceDataException("invalid name");
            }
            if (!validator.isPassword(user.getPassword())) {
                throw new ServiceDataException("invalid password");
            }
            if (!validator.isEmail(user.getEmail())) {
                throw new ServiceDataException("invalid email");
            }
            if (!validator.isPhoneNumber(user.getPhone())) {
                throw new ServiceDataException("invalid phone");
            }
            user.setRole(Role.USER);
            user.setStatus(State.ACTIVE);
            user.setRegisterDate(new Date());
            userDao.register(user);
            user.setPassword(createHash(user.getPassword()));
        } catch (DaoException | ServiceDataException e) {
            LOGGER.debug(e.getMessage());
            throw new ServiceException(e);
        }
    }

    @Override
    public void changePassword(String oldPassword, String newPassword) throws ServiceException {
        UserDao userDao = transaction.createDao(EntityType.USER);
        UserDataValidator validator = new UserDataValidator();
        try {
            if (validator.isPassword(newPassword)) {
                userDao.changePassword(createHash(oldPassword), createHash(newPassword));
            }
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    private String createHash(String password) {
        return DigestUtils.sha256Hex(password);
    }
}
