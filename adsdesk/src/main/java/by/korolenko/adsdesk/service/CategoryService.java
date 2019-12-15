package by.korolenko.adsdesk.service;

import by.korolenko.adsdesk.bean.Category;
import by.korolenko.adsdesk.service.exception.ServiceException;

import java.util.List;

/**
 * @author Sergei Korolenko
 * @version 1.0
 */
public interface CategoryService {

    List<Category> readCategory() throws ServiceException;

    List<Category> readSubcategoryByCategoryId(Integer categoryId) throws ServiceException;

    List<Category> readSubcategory() throws ServiceException;
}
