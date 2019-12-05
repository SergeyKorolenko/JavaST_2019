package by.korolenko.adsdesk.controller.action.common;

import by.korolenko.adsdesk.bean.enums.EntityType;
import by.korolenko.adsdesk.controller.action.Action;
import by.korolenko.adsdesk.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterAction extends Action {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        UserService userService = factory.createService(EntityType.USER);

        return "/login.jsp";
    }
}
