package by.korolenko.adsdesk.controller.action.impl.alluser;

import by.korolenko.adsdesk.bean.User;
import by.korolenko.adsdesk.bean.enums.EntityType;
import by.korolenko.adsdesk.controller.action.AllUserAction;
import by.korolenko.adsdesk.service.UserService;
import by.korolenko.adsdesk.service.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterAction extends AllUserAction {

    private static final String FORWARD_PAGE = "/registration.jsp";
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
                    return FORWARD_PAGE;
                }
                setRedirect(true);
                return "/login.html";
            }
            req.setAttribute("message", "password and confirm password are different");
            return FORWARD_PAGE;
        }
        req.setAttribute("message", "not all data");
        return FORWARD_PAGE;
    }
}
