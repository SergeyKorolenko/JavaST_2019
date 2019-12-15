package by.korolenko.adsdesk.service.impl;

import by.korolenko.adsdesk.bean.Comment;
import by.korolenko.adsdesk.bean.enums.EntityType;
import by.korolenko.adsdesk.dao.CommentDao;
import by.korolenko.adsdesk.dao.exception.DaoException;
import by.korolenko.adsdesk.service.AbstractService;
import by.korolenko.adsdesk.service.CommentService;
import by.korolenko.adsdesk.service.exception.ServiceDataException;
import by.korolenko.adsdesk.service.exception.ServiceException;
import by.korolenko.adsdesk.service.validator.CommentDataValidator;

import java.util.List;

/**
 * @author Sergei Korolenko
 * @version 1.0
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

    @Override
    public void add(Comment comment) throws ServiceException {
        CommentDao commentDao = transaction.createDao(EntityType.COMMENT);
        CommentDataValidator validator = new CommentDataValidator();
        try {
            if (!validator.isText(comment.getComment())) {
                throw new ServiceDataException("invalid comment data");
            }
            commentDao.create(comment);
        } catch (DaoException | ServiceDataException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public int countOfComment(Integer adsId) throws ServiceException {
        CommentDao commentDao = transaction.createDao(EntityType.COMMENT);
        try {
            return commentDao.countOfComment(adsId);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }
}
