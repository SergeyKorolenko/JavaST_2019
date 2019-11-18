package by.korolenko.adsdesk.dao.mysqlimpl;

import by.korolenko.adsdesk.bean.Category;
import by.korolenko.adsdesk.dao.AbstractDao;
import by.korolenko.adsdesk.dao.CategoryDao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CategoryDaoMySqlImpl extends AbstractDao implements CategoryDao {

    private final static String SQL_FIND_CATEGORY_LIST = "SELECT `id`, `name` FROM `category;`";

    @Override
    public List<Category> findAll() throws SQLException {

        List<Category> categories = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(SQL_FIND_CATEGORY_LIST);
        while (resultSet.next()) {
            Category category = new Category();
            category.setId(resultSet.getInt("id"));
            category.setCategoryName(resultSet.getString("name"));
            categories.add(category);
        }
        resultSet.close();
        statement.close();
        return categories;
    }

    @Override
    public Category findEntityById(Integer id) throws SQLException {
        return null;
    }

    @Override
    public void delete(Integer id) throws SQLException {
    }

    @Override
    public void create(Category entity) throws SQLException {
    }

    @Override
    public void update(Category entity) throws SQLException {
    }
}
