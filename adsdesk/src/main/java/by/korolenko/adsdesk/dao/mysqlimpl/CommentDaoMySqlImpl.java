package by.korolenko.adsdesk.dao.mysqlimpl;

import by.korolenko.adsdesk.bean.Comment;
import by.korolenko.adsdesk.dao.AbstractDao;
import by.korolenko.adsdesk.dao.CommentDao;

import java.sql.SQLException;
import java.util.List;

public class CommentDaoMySqlImpl extends AbstractDao implements CommentDao {
    @Override
    public List<Comment> findAll() throws SQLException {
        return null;
    }

    @Override
    public Comment findEntityById(Integer id) throws SQLException {
        return null;
    }

    @Override
    public void delete(Integer id) throws SQLException {
    }

    @Override
    public void create(Comment entity) throws SQLException {
    }

    @Override
    public void update(Comment entity) throws SQLException {
    }
}
