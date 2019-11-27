package by.korolenko.adsdesk.controller.action.common;

import by.korolenko.adsdesk.controller.action.Action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainAction extends Action {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        return "/WEB-INF/jsp/login.jsp";
    }
}
