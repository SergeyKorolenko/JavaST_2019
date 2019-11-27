package by.korolenko.adsdesk.service;

import by.korolenko.adsdesk.bean.Category;
import by.korolenko.adsdesk.service.exception.ServiceException;

import java.util.List;

public interface CategoryService {

    List<Category> readAll() throws ServiceException;
}
