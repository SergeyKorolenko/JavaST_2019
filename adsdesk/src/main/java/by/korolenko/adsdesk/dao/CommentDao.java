package by.korolenko.adsdesk.dao;

import by.korolenko.adsdesk.bean.Comment;
import by.korolenko.adsdesk.dao.exception.DaoException;

import java.util.List;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 14.11.2019
 */
public interface CommentDao extends Dao<Comment> {

    List<Comment> findByAdsId(Integer adsId) throws DaoException;

    List<Comment> findByUserId(Integer userId) throws DaoException;

    int countOfComment(Integer adsId) throws DaoException;
}
