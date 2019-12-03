package by.korolenko.adsdesk.controller.action.common;

import by.korolenko.adsdesk.bean.Ads;
import by.korolenko.adsdesk.bean.Category;
import by.korolenko.adsdesk.bean.User;
import by.korolenko.adsdesk.bean.enums.EntityType;
import by.korolenko.adsdesk.controller.action.Action;
import by.korolenko.adsdesk.service.AdsService;
import by.korolenko.adsdesk.service.CategoryService;
import by.korolenko.adsdesk.service.UserService;
import by.korolenko.adsdesk.service.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class LoginAction extends Action {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        UserService userService = factory.createService(EntityType.USER);
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        if (login != null && password != null) {
            try {
                User user = userService.findByLoginAndPassword(login, password);
                if (user != null) {
                    HttpSession session = req.getSession(false);
                    session.setAttribute("authorizedUser", user);
                    setRedirect(true);
                    return "/main.html";
                }
            } catch (ServiceException e) {
                return "/error.jsp";
            }
        }
        return "/login.jsp";
    }
}
