package by.korolenko.adsdesk.controller.action.common;

import by.korolenko.adsdesk.bean.User;
import by.korolenko.adsdesk.bean.enums.EntityType;
import by.korolenko.adsdesk.controller.action.Action;
import by.korolenko.adsdesk.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterAction extends Action {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        UserService userService = factory.createService(EntityType.USER);
        String name = req.getParameter("name");
        String login = req.getParameter("login");
        String email = req.getParameter("inputEmail");
        String phone = req.getParameter("phone");
        String password = req.getParameter("inputPassword");
        String confirmPassword = req.getParameter("confirmPassword");
        User user = new User();
        user.setName(name);
        user.setLogin(login);
        user.setPhone(Long.parseLong(phone));
        user.setEmail(email);
        user.setPassword(password);
        System.out.println(user);
        return "/login.jsp";
    }
}
