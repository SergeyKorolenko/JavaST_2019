package by.korolenko.adsdesk.controller.action.impl.alluser;

import by.korolenko.adsdesk.controller.action.AllUserAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginPageAction extends AllUserAction {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        return "/login.jsp";
    }
}
