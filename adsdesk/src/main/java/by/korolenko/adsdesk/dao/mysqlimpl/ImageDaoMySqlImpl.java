package by.korolenko.adsdesk.dao.mysqlimpl;

import by.korolenko.adsdesk.bean.Image;
import by.korolenko.adsdesk.dao.AbstractDao;
import by.korolenko.adsdesk.dao.ImageDao;

import java.sql.SQLException;
import java.util.List;

public class ImageDaoMySqlImpl extends AbstractDao implements ImageDao {
    @Override
    public List<Image> findAll() throws SQLException {
        return null;
    }

    @Override
    public Image findEntityById(Integer id) throws SQLException {
        return null;
    }

    @Override
    public void delete(Integer id) throws SQLException {
    }

    @Override
    public void create(Image entity) throws SQLException {
    }

    @Override
    public void update(Image entity) throws SQLException {
    }
}
