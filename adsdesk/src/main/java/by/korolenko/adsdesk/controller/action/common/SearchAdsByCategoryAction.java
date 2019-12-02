package by.korolenko.adsdesk.controller.action.common;

import by.korolenko.adsdesk.bean.Ads;
import by.korolenko.adsdesk.bean.Category;
import by.korolenko.adsdesk.bean.enums.EntityType;
import by.korolenko.adsdesk.controller.action.Action;
import by.korolenko.adsdesk.service.AdsService;
import by.korolenko.adsdesk.service.CategoryService;
import by.korolenko.adsdesk.service.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class SearchAdsByCategoryAction extends Action {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        String id = req.getParameter("id");
        AdsService adsService = factory.createService(EntityType.ADS);
        try {
            List<Ads> adsList = adsService.findByCategory(Integer.parseInt(id));
            req.setAttribute("adsList", adsList);
            CategoryService categoryService = factory.createService(EntityType.CATEGORY);
            List<Category> categories = categoryService.readAll();
            req.setAttribute("categoryList", categories);
        } catch (ServiceException | NumberFormatException e) {
            return "/error.jsp";
        }
        return "/main/main.jsp";
    }
}
