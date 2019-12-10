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

    private static final String SQL_READ_CATEGORY_LIST =
            "SELECT id, name FROM category WHERE parent_id IS NULL";
    private static final String SQL_FIND_SUBCATEGORY_BY_CATEGORY_ID =
            "SELECT id, name, parent_id FROM category WHERE parent_id = ?";
    private static final String SQL_FIND_SUBCATEGORY =
            "SELECT id, name FROM category WHERE parent_id IS NOT NULL";

    @Override
    public List<Category> readCategory() throws DaoException {
        try (PreparedStatement statement = connection.
                prepareStatement(SQL_READ_CATEGORY_LIST);
             ResultSet resultSet =
                     statement.executeQuery()) {
            List<Category> categories = new ArrayList<>();
            while (resultSet.next()) {
                Category category = new Category();
                category.setId(resultSet.getInt("id"));
                category.setCategoryName(resultSet.
                        getString("name"));
                categories.add(category);
            }
            return categories;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public List<Category> readSubcategoryByCategoryId(Integer categoryId) throws DaoException {
        try (PreparedStatement statement = connection.
                prepareStatement(SQL_FIND_SUBCATEGORY_BY_CATEGORY_ID)) {
            statement.setInt(1, categoryId);
            try (ResultSet resultSet = statement.executeQuery()) {
                List<Category> categories = new ArrayList<>();
                while (resultSet.next()) {
                    Category category = new Category();
                    category.setId(resultSet.getInt("id"));
                    category.setCategoryName(resultSet.
                            getString("name"));
                    Category parent = new Category();
                    parent.setId(categoryId);
                    category.setParent(parent);
                    categories.add(category);
                }
                return categories;
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public List<Category> readSubcategory() throws DaoException {
        try (PreparedStatement statement = connection.
                prepareStatement(SQL_FIND_SUBCATEGORY);
             ResultSet resultSet =
                     statement.executeQuery()) {
            List<Category> categories = new ArrayList<>();
            while (resultSet.next()) {
                Category category = new Category();
                category.setId(resultSet.getInt("id"));
                category.setCategoryName(resultSet.
                        getString("name"));
                categories.add(category);
            }
            return categories;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

}
