package by.korolenko.adsdesk.dao.mysqlimpl;

import by.korolenko.adsdesk.bean.Ads;
import by.korolenko.adsdesk.bean.Comment;
import by.korolenko.adsdesk.bean.User;
import by.korolenko.adsdesk.dao.AbstractDao;
import by.korolenko.adsdesk.dao.CommentDao;
import by.korolenko.adsdesk.dao.exception.DaoException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 14.11.2019
 */
public class CommentDaoMySqlImpl extends AbstractDao implements CommentDao {

    private static final String SQL_FIND_BY_ID = "SELECT id, comment," +
            "added_datetime, ads_id, user_id FROM ads_desk.comment WHERE id = ?";

    private static final String SQL_FIND_BY_ADS_ID = "SELECT id, comment," +
            "added_datetime, ads_id, user_id FROM ads_desk.comment " +
            "WHERE ads_id = ?";

    private static final String SQL_FIND_BY_USER_ID = "SELECT id, comment," +
            "added_datetime, ads_id, user_id FROM ads_desk.comment " +
            "WHERE user_id = ?";

    /**
     * This method returns an entity by id.
     *
     * @param id id
     * @return entity
     * @throws DaoException exception
     */
    @Override
    public Comment findById(Integer id) throws DaoException {
        try (PreparedStatement statement = connection.
                prepareStatement(SQL_FIND_BY_ID)) {
            statement.setString(1, id.toString());
            try (ResultSet resultSet = statement.executeQuery()) {
                Comment comment = new Comment();
                while (resultSet.next()) {
                    comment.setId(resultSet.getInt("id"));
                    comment.setComment(resultSet.getString("comment"));
                    comment.setAddedDate(resultSet.getDate("added_datetime"));
                    Ads ads = new Ads();
                    ads.setId(resultSet.getInt("ads_id"));
                    comment.setAds(ads);
                    User user = new User();
                    user.setId(resultSet.getInt("user_id"));
                    comment.setUser(user);
                }
                return comment;
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    /**
     * This method deletes an entity by id.
     *
     * @param id id
     * @throws DaoException exception
     */
    @Override
    public void delete(Integer id) throws DaoException {

    }

    /**
     * This method adds an entity to the database.
     *
     * @param entity entity
     * @throws DaoException exception
     */
    @Override
    public void create(Comment entity) throws DaoException {

    }

    /**
     * This method updates an entity.
     *
     * @param entity entity
     * @throws DaoException exception
     */
    @Override
    public void update(Comment entity) throws DaoException {

    }

    @Override
    public List<Comment> findByAdsId(Integer adsId) throws DaoException {
        try (PreparedStatement statement =
                     connection.prepareStatement(SQL_FIND_BY_ADS_ID)) {
            statement.setInt(1, adsId);
            try (ResultSet resultSet = statement.executeQuery()) {
                List<Comment> comments = new ArrayList<>();
                while (resultSet.next()) {
                    Comment comment = new Comment();
                    comment.setId(resultSet.getInt("id"));
                    comment.setComment(resultSet.getString("comment"));
                    comment.setAddedDate(resultSet.getDate("added_datetime"));
                    User user = new User();
                    user.setId(resultSet.getInt("user_id"));
                    comment.setUser(user);
                    Ads ads = new Ads();
                    ads.setId(adsId);
                    comment.setAds(ads);
                    comments.add(comment);
                }
                return comments;
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public List<Comment> findByUserId(Integer userId) throws DaoException {
        try (PreparedStatement statement =
                     connection.prepareStatement(SQL_FIND_BY_USER_ID)) {
            statement.setString(1, userId.toString());
            try (ResultSet resultSet = statement.executeQuery()) {
                List<Comment> comments = new ArrayList<>();
                while (resultSet.next()) {
                    Comment comment = new Comment();
                    comment.setId(resultSet.getInt("id"));
                    comment.setComment(resultSet.getString("comment"));
                    comment.setAddedDate(resultSet.getDate("added_datetime"));
                    User user = new User();
                    user.setId(userId);
                    comment.setUser(user);
                    Ads ads = new Ads();
                    ads.setId(resultSet.getInt("ads_id"));
                    comment.setAds(ads);
                    comments.add(comment);
                }
                return comments;
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }
}
