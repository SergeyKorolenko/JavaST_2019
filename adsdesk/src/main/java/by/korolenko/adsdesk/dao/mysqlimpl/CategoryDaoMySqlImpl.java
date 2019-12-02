package by.korolenko.adsdesk.dao.mysqlimpl;

import by.korolenko.adsdesk.bean.Category;
import by.korolenko.adsdesk.dao.AbstractDao;
import by.korolenko.adsdesk.dao.CategoryDao;
import by.korolenko.adsdesk.dao.exception.DaoException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 14.11.2019
 */
public class CategoryDaoMySqlImpl extends AbstractDao implements CategoryDao {

    private final static String SQL_READ_LIST =
            "SELECT `id`, `name`, `parent_id` FROM `category`";
    private final static String SQL_FIND_BY_NAME =
            "SELECT `id`, `name`, `parent_id` FROM `category` WHERE `name` = ?";
    private final static String SQL_FIND_SUBCATEGORY_BY_CATEGORY_ID =
            "";

    @Override
    public List<Category> readAll() throws DaoException {
        try (PreparedStatement statement = connection.
                prepareStatement(SQL_READ_LIST);
             ResultSet resultSet =
                     statement.executeQuery()) {
            List<Category> categories = new ArrayList<>();
            while (resultSet.next()) {
                Category category = new Category();
                category.setId(resultSet.getInt("id"));
                category.setCategoryName(resultSet.
                        getString("name"));
                String parentId = resultSet.getString("parent_id");
                if (parentId != null) {
                    Category parent = new Category();
                    parent.setId(Integer.parseInt(parentId));
                    category.setParent(parent);
                }
                categories.add(category);
            }
            return categories;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public Category findByName(String name) throws DaoException {
        return null;
    }

    @Override
    public List<Category> findSubcategoryByCategoryId(Integer id)
            throws DaoException {
        return null;
    }


    /**
     * This method returns an entity by id.
     *
     * @param id id
     * @return entity
     * @throws DaoException exception
     */
    @Override
    public Category findById(Integer id) throws DaoException {
        return null;
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
    public void create(Category entity) throws DaoException {

    }

    /**
     * This method updates an entity.
     *
     * @param entity entity
     * @throws DaoException exception
     */
    @Override
    public void update(Category entity) throws DaoException {

    }
}
