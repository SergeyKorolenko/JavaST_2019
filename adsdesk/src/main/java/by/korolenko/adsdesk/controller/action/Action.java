package by.korolenko.adsdesk.controller.action;

import by.korolenko.adsdesk.service.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Sergei Korolenko
 * @version 1.0
 */
public abstract class Action {

    private boolean isRedirect;
    private boolean isHeader;

    public boolean isHeader() {
        return isHeader;
    }

    public void setHeader(boolean header) {
        isHeader = header;
    }

    public boolean isRedirect() {
        return isRedirect;
    }

    public void setRedirect(boolean redirect) {
        isRedirect = redirect;
    }

    protected ServiceFactory factory;

    public void setFactory(ServiceFactory factory) {
        this.factory = factory;
    }

    public abstract String execute(HttpServletRequest req,
                                   HttpServletResponse resp);

}
