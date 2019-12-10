package by.korolenko.adsdesk.dao;

import by.korolenko.adsdesk.bean.Category;
import by.korolenko.adsdesk.dao.exception.DaoException;
import java.util.List;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 14.11.2019
 */
public interface CategoryDao extends Dao<Category> {

    List<Category> readCategory() throws DaoException;

    List<Category> readSubcategoryByCategoryId(Integer categoryId) throws DaoException;

    List<Category> readSubcategory() throws DaoException;
}
