package by.korolenko.adsdesk.controller.action.impl.user;

import by.korolenko.adsdesk.bean.Ads;
import by.korolenko.adsdesk.bean.Category;
import by.korolenko.adsdesk.bean.Locality;
import by.korolenko.adsdesk.bean.User;
import by.korolenko.adsdesk.bean.enums.EntityType;
import by.korolenko.adsdesk.bean.enums.State;
import by.korolenko.adsdesk.controller.action.AuthorizedUserAction;
import by.korolenko.adsdesk.controller.action.UserAction;
import by.korolenko.adsdesk.service.AdsService;
import by.korolenko.adsdesk.service.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddAdsAction extends UserAction {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        String heading = req.getParameter("heading");
        String text = req.getParameter("mainText");
        String price = req.getParameter("price");
        String localityId = req.getParameter("localitySelect");
        String categoryId = req.getParameter("categorySelect");
        String userId = req.getParameter("userId");
        String bargain = req.getParameter("bargain");
        if (heading != null && text != null && price != null && localityId != null
                && categoryId != null && userId != null) {
            AdsService adsService = factory.createService(EntityType.ADS);
            Ads ads = new Ads();
            ads.setHeading(heading);
            ads.setText(text);
            Category category = new Category();
            category.setId(Integer.parseInt(categoryId));
            Locality locality = new Locality();
            locality.setId(Integer.parseInt(localityId));
            if (bargain != null) {
                ads.setBargain(State.ACTIVE);
            } else {
                ads.setBargain(State.INACTIVE);
            }
            ads.setPrice(Double.parseDouble(price));
            ads.setCategory(category);
            User user = new User();
            user.setId(Integer.parseInt(userId));
            ads.setUser(user);
            ads.setLocality(locality);
            try {
                adsService.create(ads);
            } catch (ServiceException e) {
                return "/error.jsp";
            }
            setRedirect(true);
            return "/main.html";
        }
        return "/error.jsp";
    }
}
