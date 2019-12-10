package by.korolenko.adsdesk.controller.action.impl;

import by.korolenko.adsdesk.bean.User;
import by.korolenko.adsdesk.bean.enums.EntityType;
import by.korolenko.adsdesk.controller.action.Action;
import by.korolenko.adsdesk.service.UserService;
import by.korolenko.adsdesk.service.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterAction extends Action {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        String name = req.getParameter("name");
        String login = req.getParameter("login");
        String email = req.getParameter("inputEmail");
        String phone = req.getParameter("phone");
        String password = req.getParameter("inputPassword");
        String confirmPassword = req.getParameter("confirmPassword");
        if (name != null && login != null && email != null && phone != null
                && password != null && confirmPassword != null) {
            if (password.equals(confirmPassword)) {
                UserService userService = factory.createService(EntityType.USER);
                User user = new User();
                user.setName(name);
                user.setLogin(login);
                user.setPhone(Long.parseLong(phone));
                user.setEmail(email);
                user.setPassword(password);
                try {
                    userService.register(user);
                } catch (ServiceException e) {
                    return "/registration.jsp";
                }
                setRedirect(true);
                return "/login.html";
            }
            return "/registration.jsp";
        }
        return "/error.jsp";
    }
}
