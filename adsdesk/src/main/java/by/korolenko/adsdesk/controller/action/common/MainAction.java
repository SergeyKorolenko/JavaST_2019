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

public class MainAction extends Action {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        try {
            CategoryService categoryService = factory.createService(EntityType.CATEGORY);
            List<Category> categories = categoryService.readAll();
            AdsService adsService = factory.createService(EntityType.ADS);
            String current = req.getParameter("currentPage");
            String recordsPage = req.getParameter("recordsPerPage");
            int currentPage;
            int recordsPerPage;
            if (current == null && recordsPage == null) {
                currentPage = 1;
                recordsPerPage = 5;
            } else {
                currentPage = Integer.parseInt(current);
                recordsPerPage = Integer.parseInt(recordsPage);
            }
            List<Ads> adsList = adsService.findAdsByPage(currentPage, recordsPerPage);
            int adsNumber = adsService.countAdsNumber();
            int nOfPages = adsNumber / recordsPerPage;
            if (nOfPages % recordsPerPage > 0) {
                nOfPages++;
            }
            req.setAttribute("adsList", adsList);
            req.setAttribute("noOfPages", nOfPages);
            req.setAttribute("currentPage", currentPage);
            req.setAttribute("recordsPerPage", recordsPerPage);
            req.setAttribute("categoryList", categories);
            return "/main.jsp";
        } catch (ServiceException e) {
            return "/error.jsp";
        }
    }
}
