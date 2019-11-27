package by.korolenko.adsdesk.controller.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ActionManager {
    String execute(Action action, HttpServletRequest request,
                   HttpServletResponse response);

    void close();
}
