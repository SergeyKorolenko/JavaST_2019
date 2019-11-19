package by.korolenko.adsdesk.service.impl;

import by.korolenko.adsdesk.bean.Category;
import by.korolenko.adsdesk.bean.enums.EntityType;
import by.korolenko.adsdesk.dao.CategoryDao;
import by.korolenko.adsdesk.service.AbstractService;
import by.korolenko.adsdesk.service.CategoryService;

import java.sql.SQLException;
import java.util.List;

public class CategoryServiceImpl extends AbstractService implements CategoryService {
    @Override
    public List<Category> findAll() {
        CategoryDao categoryDao = wrapperConnection.createDao(EntityType.CATEGORY);
        List<Category> categories = null;
        try {
            categories = categoryDao.findAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categories;
    }
}
