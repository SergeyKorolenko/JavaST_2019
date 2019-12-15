package by.korolenko.adsdesk.controller.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Sergei Korolenko
 * @version 1.0
 */
public interface ActionManager {

    String execute(Action action, HttpServletRequest request,
                   HttpServletResponse response);

    void close();
}
