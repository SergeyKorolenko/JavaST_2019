package by.korolenko.adsdesk.service.impl;

import by.korolenko.adsdesk.bean.Category;
import by.korolenko.adsdesk.dao.CategoryDao;
import by.korolenko.adsdesk.dao.mysqlimpl.CategoryDaoMySqlImpl;
import by.korolenko.adsdesk.dao.pool.ConnectionPool;
import by.korolenko.adsdesk.service.AbstractService;
import by.korolenko.adsdesk.service.CategoryService;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class CategoryServiceImpl extends AbstractService implements CategoryService {
    @Override
    public List<Category> findAll() {
        Connection connection = ConnectionPool.getInstance().getConnection();
        CategoryDao categoryDao = new CategoryDaoMySqlImpl();
        List<Category> categories = null;
        try {
            categories = categoryDao.findAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ConnectionPool.getInstance().returnConnection(connection);
        return categories;
    }
}
