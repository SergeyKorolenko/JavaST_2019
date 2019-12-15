package by.korolenko.adsdesk.dao.mysqlimpl;

import by.korolenko.adsdesk.bean.Ads;
import by.korolenko.adsdesk.bean.Image;
import by.korolenko.adsdesk.dao.AbstractDao;
import by.korolenko.adsdesk.dao.ImageDao;
import by.korolenko.adsdesk.dao.exception.DaoException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Sergei Korolenko
 * @version 1.0
 */
public class ImageDaoMySqlImpl extends AbstractDao implements ImageDao {

    private static final String SQL_FIND_BY_ID = "SELECT id, image_url," +
            "ads_id FROM image WHERE id = ?";

    private static final String SQL_FIND_BY_ADS_ID = "SELECT id, image_url," +
            "ads_id FROM image WHERE ads_id = ?";

    /**
     * This method returns an entity by id.
     *
     * @param id id
     * @return entity
     * @throws DaoException exception
     */
    @Override
    public Image findById(Integer id) throws DaoException {
        try (PreparedStatement statement =
                     connection.prepareStatement(SQL_FIND_BY_ID)) {
            statement.setString(1, id.toString());
            try (ResultSet resultSet = statement.executeQuery()) {
                Image image = new Image();
                while (resultSet.next()) {
                    image.setId(id);
                    image.setImageUrl(resultSet.getString("image_url"));
                    Ads ads = new Ads();
                    ads.setId(resultSet.getInt("ads_id"));
                }
                return image;
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public List<Image> findByAdsId(Integer adsId) throws DaoException {
        try (PreparedStatement statement =
                     connection.prepareStatement(SQL_FIND_BY_ADS_ID)) {
            statement.setString(1, adsId.toString());
            try (ResultSet resultSet = statement.executeQuery()) {
                List<Image> images = new ArrayList<>();
                while (resultSet.next()) {
                    Image image = new Image();
                    image.setId(resultSet.getInt("id"));
                    image.setImageUrl(resultSet.getString("image_url"));
                    Ads ads = new Ads();
                    ads.setId(adsId);
                    images.add(image);
                }
                return images;
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }
}
