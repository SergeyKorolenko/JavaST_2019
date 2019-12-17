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
public class AdsSortAction extends AllUserAction {

    private static final String SORT_BY_DATE = "date";
    private static final String INCREASE_PRICE_SORT = "increase";
    private static final String DECREASE_PRICE_SORT = "decrease";

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        String sort = req.getParameter("sort");
        if (sort != null) {
            try {
                AdsService adsService = factory.createService(EntityType.ADS);
                List<Ads> adsList = null;
                if (SORT_BY_DATE.equals(sort)) {
                    adsList = adsService.sortByDate();
                }
                if (INCREASE_PRICE_SORT.equals(sort)) {
                    adsList = adsService.sortByIncreasePrice();
                }
                if (DECREASE_PRICE_SORT.equals(sort)) {
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
