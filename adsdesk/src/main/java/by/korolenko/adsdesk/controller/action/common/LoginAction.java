package by.korolenko.adsdesk.controller.action.common;

import by.korolenko.adsdesk.bean.User;
import by.korolenko.adsdesk.bean.enums.EntityType;
import by.korolenko.adsdesk.controller.action.Action;
import by.korolenko.adsdesk.service.UserService;
import by.korolenko.adsdesk.service.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginAction extends Action {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        UserService userService = factory.createService(EntityType.USER);
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        try {
            User user = userService.findByLoginAndPassword(login, password);
        } catch (ServiceException e) {
            return "/WEB-INF/jsp/error.jsp";
        }
        return "/WEB-INF/jsp/main/main.jsp";
    }
}
