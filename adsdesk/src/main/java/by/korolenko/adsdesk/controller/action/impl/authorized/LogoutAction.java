package by.korolenko.adsdesk.controller.action.impl.authorized;

import by.korolenko.adsdesk.controller.action.AuthorizedUserAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutAction extends AuthorizedUserAction {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        HttpSession session = req.getSession();
        session.invalidate();
        setRedirect(true);
        return "/main.html";
    }
}
