package by.korolenko.adsdesk.controller.action.impl;

import by.korolenko.adsdesk.bean.enums.EntityType;
import by.korolenko.adsdesk.controller.action.Action;
import by.korolenko.adsdesk.service.UserService;
import by.korolenko.adsdesk.service.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ChangePasswordAction extends Action {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        String oldPassword = req.getParameter("oldPassword");
        String newPassword = req.getParameter("newPassword");
        String confNewPassword = req.getParameter("confNewPassword");
        if (newPassword != null && oldPassword != null && confNewPassword != null) {
            if (newPassword.equals(confNewPassword)) {
                UserService userService = factory.createService(EntityType.USER);
                try {
                    userService.changePassword(oldPassword, newPassword);
                    setRedirect(true);
                    return "/main.html";
                } catch (ServiceException e) {
                    return "/error.jsp";
                }
            }
        }
        return "/error.jsp";
    }
}
