package by.korolenko.adsdesk.controller.action.impl;

import by.korolenko.adsdesk.controller.action.Action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterPageAction extends Action {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        return "/registration.jsp";
    }
}