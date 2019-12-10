package by.korolenko.adsdesk.controller.action.impl;

import by.korolenko.adsdesk.bean.User;
import by.korolenko.adsdesk.bean.enums.EntityType;
import by.korolenko.adsdesk.controller.action.Action;
import by.korolenko.adsdesk.service.UserService;
import by.korolenko.adsdesk.service.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginAction extends Action {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        if (login != null && password != null) {
            try {
                UserService userService = factory.createService(EntityType.USER);
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