package by.korolenko.adsdesk.controller.action.impl.alluser;

import by.korolenko.adsdesk.bean.Ads;
import by.korolenko.adsdesk.bean.Category;
import by.korolenko.adsdesk.bean.enums.EntityType;
import by.korolenko.adsdesk.controller.action.AllUserAction;
import by.korolenko.adsdesk.service.AdsService;
import by.korolenko.adsdesk.service.CategoryService;
import by.korolenko.adsdesk.service.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author Sergei Korolenko
 * @version 1.0
 */
public class SearchAdsBySubstringAction extends AllUserAction {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        String substring = req.getParameter("search");
        AdsService adsService = factory.createService(EntityType.ADS);
        try {
            List<Ads> adsList = adsService.findByIncludingString(substring);
            req.setAttribute("adsList", adsList);
            CategoryService categoryService = factory.createService(EntityType.CATEGORY);
            List<Category> categories = categoryService.readCategory();
            req.setAttribute("categoryList", categories);
            return "/main.jsp";
        } catch (ServiceException | NumberFormatException e) {
            return "/error.jsp";
        }
    }
}
