package by.korolenko.adsdesk.dao;

import by.korolenko.adsdesk.bean.Category;
import by.korolenko.adsdesk.dao.exception.DaoException;
import java.util.List;

public interface CategoryDao extends Dao<Category> {

    List<Category> readAll() throws DaoException;

    Category findCategoryByName(String name) throws DaoException;

    List<Category> findSubcategoryByCategoryId(Integer id) throws DaoException;
}
