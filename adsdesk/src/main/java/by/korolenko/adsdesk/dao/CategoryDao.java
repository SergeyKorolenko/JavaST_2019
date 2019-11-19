package by.korolenko.adsdesk.dao;

import by.korolenko.adsdesk.bean.Category;

import java.util.List;

public interface CategoryDao extends Dao<Category> {

    Category findCategoryByName(String name);

    List<Category> findSubcategoryByCategoryId(Integer id);
}
