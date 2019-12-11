package by.korolenko.adsdesk.controller.action.impl;

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

public class AdsSortAction extends Action {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        String sort = req.getParameter("sort");
        if (sort != null) {
            try {
                AdsService adsService = factory.createService(EntityType.ADS);
                List<Ads> adsList = null;
                if ("date".equals(sort)) {
                    adsList = adsService.sortByDate();
                }
                if ("increase".equals(sort)) {
                    adsList = adsService.sortByIncreasePrice();
                }
                if ("decrease".equals(sort)) {
                    adsList = adsService.sortByDecreasePrice();
                }
                req.setAttribute("adsList", adsList);
                CategoryService categoryService = factory.createService(EntityType.CATEGORY);
                List<Category> categories = categoryService.readCategory();
                req.setAttribute("categoryList", categories);
                return "/main.jsp";
            } catch (ServiceException | NumberFormatException e) {
                return "/error.jsp";
            }
        }
        return "/error.jsp";
    }
}
