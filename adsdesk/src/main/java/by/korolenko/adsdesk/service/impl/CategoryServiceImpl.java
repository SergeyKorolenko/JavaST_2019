package by.korolenko.adsdesk.service.impl;

import by.korolenko.adsdesk.bean.Category;
import by.korolenko.adsdesk.bean.enums.EntityType;
import by.korolenko.adsdesk.dao.CategoryDao;
import by.korolenko.adsdesk.dao.exception.DaoException;
import by.korolenko.adsdesk.service.AbstractService;
import by.korolenko.adsdesk.service.CategoryService;
import by.korolenko.adsdesk.service.exception.ServiceException;

import java.util.List;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 14.11.2019
 */
public class CategoryServiceImpl extends AbstractService implements CategoryService {
    @Override
    public List<Category> readCategory() throws ServiceException {
        CategoryDao categoryDao = transaction.createDao(EntityType.CATEGORY);
        try {
            return categoryDao.readCategory();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Category> readSubcategoryByCategoryId(Integer categoryId) throws ServiceException {
        CategoryDao categoryDao = transaction.createDao(EntityType.CATEGORY);
        try {
            return categoryDao.readSubcategoryByCategoryId(categoryId);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Category> readSubcategory() throws ServiceException {
        CategoryDao categoryDao = transaction.createDao(EntityType.CATEGORY);
        try {
            return categoryDao.readSubcategory();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }
}
