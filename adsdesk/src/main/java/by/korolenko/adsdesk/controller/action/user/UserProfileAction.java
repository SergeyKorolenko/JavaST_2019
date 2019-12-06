package by.korolenko.adsdesk.controller.action.user;

import by.korolenko.adsdesk.bean.Ads;
import by.korolenko.adsdesk.bean.User;
import by.korolenko.adsdesk.bean.enums.EntityType;
import by.korolenko.adsdesk.controller.action.Action;
import by.korolenko.adsdesk.service.AdsService;
import by.korolenko.adsdesk.service.UserService;
import by.korolenko.adsdesk.service.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class UserProfileAction extends Action {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        String id = req.getParameter("id");
        UserService userService = factory.createService(EntityType.USER);
        try {
            User user = userService.findById(Integer.parseInt(id));
            req.setAttribute("user", user);
            AdsService adsService = factory.createService(EntityType.ADS);
            List<Ads> adsList = adsService.findByUserId(Integer.parseInt(id));
            req.setAttribute("userAdsList", adsList);
            return "/profile.jsp";
        } catch (ServiceException | NumberFormatException e) {
            return "/error.jsp";
        }
    }
}
