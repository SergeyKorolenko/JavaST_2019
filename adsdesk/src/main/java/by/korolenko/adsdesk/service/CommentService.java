package by.korolenko.adsdesk.service;

import by.korolenko.adsdesk.bean.Comment;
import by.korolenko.adsdesk.service.exception.ServiceException;

import java.util.List;

/**
 * @author Sergei Korolenko
 * @version 1.0
 */
public interface CommentService {

    List<Comment> findByAdsId(Integer adsId) throws ServiceException;

    void add(Comment comment) throws ServiceException;

    int countOfComment(Integer adsId) throws ServiceException;

}
