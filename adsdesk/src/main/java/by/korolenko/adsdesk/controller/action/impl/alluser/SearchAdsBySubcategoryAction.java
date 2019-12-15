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

public class SearchAdsBySubcategoryAction extends AllUserAction {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        String id = req.getParameter("id");
        if (id != null) {
            try {
                AdsService adsService = factory.createService(EntityType.ADS);
                List<Ads> adsList = adsService.findByCategory(Integer.parseInt(id));
                req.setAttribute("adsList", adsList);
                CategoryService categoryService = factory.createService(EntityType.CATEGORY);
                List<Category> categories = categoryService.readCategory();
                req.setAttribute("categoryList", categories);
                List<Category> subcategoryList = categoryService.readSubcategoryByCategoryId(Integer.parseInt(id));
                req.setAttribute("subcategoryList", subcategoryList);
                return "/main.jsp";
            } catch (ServiceException | NumberFormatException e) {
                return "/error.jsp";
            }
        }
        return "/error.jsp";
    }
}
