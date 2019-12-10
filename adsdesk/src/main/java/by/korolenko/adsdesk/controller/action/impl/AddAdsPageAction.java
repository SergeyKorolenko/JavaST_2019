package by.korolenko.adsdesk.controller.action.impl;

import by.korolenko.adsdesk.bean.Category;
import by.korolenko.adsdesk.bean.Locality;
import by.korolenko.adsdesk.bean.enums.EntityType;
import by.korolenko.adsdesk.controller.action.Action;
import by.korolenko.adsdesk.service.CategoryService;
import by.korolenko.adsdesk.service.LocalityService;
import by.korolenko.adsdesk.service.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class AddAdsPageAction extends Action {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        try {
            LocalityService localityService = factory.createService(EntityType.LOCALITY);
            List<Locality> localities = localityService.readAll();
            CategoryService categoryService = factory.createService(EntityType.CATEGORY);
            List<Category> categories = categoryService.readSubcategory();
            req.setAttribute("localities", localities);
            req.setAttribute("categories", categories);
            return "/adsAdd.jsp";
        } catch (ServiceException e) {
            return "/error.jsp";
        }
    }
}
