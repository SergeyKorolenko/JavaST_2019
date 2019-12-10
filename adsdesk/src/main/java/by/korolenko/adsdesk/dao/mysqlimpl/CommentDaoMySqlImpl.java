package by.korolenko.adsdesk.dao.mysqlimpl;

import by.korolenko.adsdesk.bean.Ads;
import by.korolenko.adsdesk.bean.Comment;
import by.korolenko.adsdesk.bean.User;
import by.korolenko.adsdesk.dao.AbstractDao;
import by.korolenko.adsdesk.dao.CommentDao;
import by.korolenko.adsdesk.dao.exception.DaoException;

import java.sql.Date;
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

    private static final String SQL_ADD = "INSERT ads_desk.comment (comment, added_datetime, ads_id, user_id) VALUES (?, ?, ?, ?)";

    private static final String SQL_COMMENT_OF_ADS = "SELECT COUNT(id) AS count FROM ads_desk.comment WHERE ads_id = ?";

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
     * This method adds an entity to the database.
     *
     * @param entity entity
     * @throws DaoException exception
     */
    @Override
    public void create(Comment entity) throws DaoException {
        try (PreparedStatement statement = connection.prepareStatement(SQL_ADD)) {
            statement.setString(1, entity.getComment());
            statement.setDate(2, new Date(entity.getAddedDate().getTime()));
            statement.setInt(3, entity.getAds().getId());
            statement.setInt(4, entity.getUser().getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
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

    @Override
    public int countOfComment(Integer adsId) throws DaoException {
        try (PreparedStatement statement = connection.prepareStatement(SQL_COMMENT_OF_ADS)) {
            statement.setInt(1, adsId);
            try (ResultSet resultSet = statement.executeQuery()) {
                int number = 0;
                while (resultSet.next()) {
                    number = resultSet.getInt("count");
                }
                return number;
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }
}
