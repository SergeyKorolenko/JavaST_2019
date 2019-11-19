package by.korolenko.adsdesk.service.impl;

import by.korolenko.adsdesk.bean.Category;
import by.korolenko.adsdesk.bean.enums.EntityType;
import by.korolenko.adsdesk.dao.CategoryDao;
import by.korolenko.adsdesk.dao.exception.DaoException;
import by.korolenko.adsdesk.service.AbstractService;
import by.korolenko.adsdesk.service.CategoryService;

import java.sql.SQLException;
import java.util.List;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 14.11.2019
 */
public class CategoryServiceImpl extends AbstractService implements CategoryService {
    @Override
    public List<Category> readAll() {
        CategoryDao categoryDao = wrapperConnection.createDao(EntityType.CATEGORY);
        List<Category> categories = null;
        try {
            categories = categoryDao.readAll();
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return categories;
    }
}
