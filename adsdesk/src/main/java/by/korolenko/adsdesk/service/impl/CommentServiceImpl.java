package by.korolenko.adsdesk.service.impl;

import by.korolenko.adsdesk.bean.Comment;
import by.korolenko.adsdesk.bean.enums.EntityType;
import by.korolenko.adsdesk.dao.CommentDao;
import by.korolenko.adsdesk.dao.exception.DaoException;
import by.korolenko.adsdesk.service.AbstractService;
import by.korolenko.adsdesk.service.CommentService;
import by.korolenko.adsdesk.service.exception.ServiceException;

import java.util.List;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 14.11.2019
 */
public class CommentServiceImpl extends AbstractService implements CommentService {
    @Override
    public List<Comment> findByAdsId(Integer adsId) throws ServiceException {
        CommentDao commentDao = transaction.createDao(EntityType.COMMENT);
        try {
            return commentDao.findByAdsId(adsId);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }
}
