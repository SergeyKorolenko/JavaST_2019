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
 */
public class CommentDaoMySqlImpl extends AbstractDao implements CommentDao {

    private static final String COMMON_PART = "SELECT comment.id, comment," +
            "added_datetime, ads_id, user_id, user.login FROM comment INNER JOIN user ON user.id = user_id";

    private static final String SQL_FIND_BY_ID = COMMON_PART + " WHERE id = ?";

    private static final String SQL_FIND_BY_ADS_ID = COMMON_PART +
            " WHERE ads_id = ?";

    private static final String SQL_FIND_BY_USER_ID = COMMON_PART +
            " WHERE user_id = ?";

    private static final String SQL_ADD =
            "INSERT comment (comment, added_datetime, ads_id, user_id)" +
                    " VALUES (?, ?, ?, ?)";

    private static final String SQL_COMMENT_OF_ADS = "SELECT COUNT(id) " +
            "AS count FROM comment WHERE ads_id = ?";

    private static final String COMMENT_TEXT = "comment";
    private static final String COMMENT_ID = "id";
    private static final String ADS_ID = "ads_id";
    private static final String USER_ID = "user_id";
    private static final String ADDED_DATETIME = "added_datetime";
    private static final String COUNT = "count";
    private static final String USER_LOGIN = "login";

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
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                Comment comment = new Comment();
                while (resultSet.next()) {
                    comment.setId(resultSet.getInt(COMMENT_ID));
                    comment.setComment(resultSet.getString(COMMENT_TEXT));
                    comment.setAddedDate(resultSet.getDate(ADDED_DATETIME));
                    Ads ads = new Ads();
                    ads.setId(resultSet.getInt(ADS_ID));
                    comment.setAds(ads);
                    User user = new User();
                    user.setId(resultSet.getInt(USER_ID));
                    user.setLogin(resultSet.getString(USER_LOGIN));
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
                return getComment(resultSet);
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
                return getComment(resultSet);
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public int countOfComment(Integer adsId) throws DaoException {
        try (PreparedStatement statement = connection.
                prepareStatement(SQL_COMMENT_OF_ADS)) {
            statement.setInt(1, adsId);
            try (ResultSet resultSet = statement.executeQuery()) {
                int number = 0;
                while (resultSet.next()) {
                    number = resultSet.getInt(COUNT);
                }
                return number;
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    private List<Comment> getComment(ResultSet resultSet) throws SQLException {
        List<Comment> comments = new ArrayList<>();
        while (resultSet.next()) {
            Comment comment = new Comment();
            comment.setId(resultSet.getInt(COMMENT_ID));
            comment.setComment(resultSet.getString(COMMENT_TEXT));
            comment.setAddedDate(resultSet.getDate(ADDED_DATETIME));
            User user = new User();
            user.setId(resultSet.getInt(USER_ID));
            user.setLogin(resultSet.getString(USER_LOGIN));
            comment.setUser(user);
            Ads ads = new Ads();
            ads.setId(resultSet.getInt(ADS_ID));
            comment.setAds(ads);
            comments.add(comment);
        }
        return comments;
    }
}
