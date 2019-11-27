package by.korolenko.adsdesk.controller.action.common;

import by.korolenko.adsdesk.bean.Category;
import by.korolenko.adsdesk.bean.enums.EntityType;
import by.korolenko.adsdesk.controller.action.Action;
import by.korolenko.adsdesk.service.CategoryService;
import by.korolenko.adsdesk.service.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class CategoryListAction extends Action {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        CategoryService categoryService = factory.
                createService(EntityType.CATEGORY);
        try {
            List<Category> categories = categoryService.readAll();
            req.setAttribute("lst", categories);
        } catch (ServiceException e) {
            return "/WEB-INF/jsp/error.jsp";
        }
        return "/WEB-INF/jsp/main/main.jsp";
    }
}
