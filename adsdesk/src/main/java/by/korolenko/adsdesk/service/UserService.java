package by.korolenko.adsdesk.service;

import by.korolenko.adsdesk.bean.User;
import by.korolenko.adsdesk.service.exception.ServiceException;

/**
 * @author Sergei Korolenko
 * @version 1.0
 */
public interface UserService {

    User findById(Integer id) throws ServiceException;

    User findByLoginAndPassword(String login, String password)
            throws ServiceException;

    void register(User user) throws ServiceException;

    void changePassword(String oldPassword, String newPassword) throws ServiceException;

    int countUser() throws ServiceException;

    void update(User user) throws ServiceException;
}
