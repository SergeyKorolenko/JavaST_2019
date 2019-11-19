package by.korolenko.adsdesk.dao.mysqlimpl;

import by.korolenko.adsdesk.bean.Category;
import by.korolenko.adsdesk.dao.AbstractDao;
import by.korolenko.adsdesk.dao.CategoryDao;
import by.korolenko.adsdesk.dao.exception.DaoException;

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

    private final static String SQL_FIND_CATEGORY_LIST =
            "SELECT `id`, `name`, `parent_id` FROM `category`";

    @Override
    public List<Category> readAll() throws DaoException {
        List<Category> categories = new ArrayList<>();
        try (Statement statement = connection.createStatement();
             ResultSet resultSet =
                     statement.executeQuery(SQL_FIND_CATEGORY_LIST)) {
            while (resultSet.next()) {
                Category category = new Category();
                category.setId(resultSet.getInt("id"));
                category.setCategoryName(resultSet.
                        getString("name"));
                Category parent = new Category();
                String parentId = resultSet.getString("parent_id");
                if (parentId != null) {
                    parent.setId(Integer.parseInt(parentId));
                }
                category.setParent(parent);
                categories.add(category);
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return categories;
    }

    @Override
    public Category findCategoryByName(String name) throws DaoException {
        return null;
    }

    @Override
    public List<Category> findSubcategoryByCategoryId(Integer id) throws DaoException {
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
    public Category findEntityById(Integer id) throws DaoException {
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
