package by.korolenko.adsdesk.controller.action.user;

import by.korolenko.adsdesk.bean.User;
import by.korolenko.adsdesk.bean.enums.EntityType;
import by.korolenko.adsdesk.controller.action.Action;
import by.korolenko.adsdesk.service.UserService;
import by.korolenko.adsdesk.service.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UserUpdateAction extends Action {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        try {
            HttpSession session = req.getSession();
            User user = (User) session.getAttribute("authorizedUser");
            if (user != null) {
                UserService userService = factory.createService(EntityType.USER);
                User userInfo = userService.findById(user.getId());
                req.setAttribute("user", userInfo);
                return "/main.jsp";
            }
        } catch (ServiceException e) {
            return "/error.jsp";
        }
        return "/error.jsp";
    }
}
