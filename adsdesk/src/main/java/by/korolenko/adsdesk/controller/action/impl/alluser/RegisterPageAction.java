package by.korolenko.adsdesk.controller.action.impl.alluser;

import by.korolenko.adsdesk.controller.action.AllUserAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Sergei Korolenko
 * @version 1.0
 */
public class RegisterPageAction extends AllUserAction {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        return "/registration.jsp";
    }
}
