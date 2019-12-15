package by.korolenko.adsdesk.controller.action;

import by.korolenko.adsdesk.service.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class Action {

    private boolean isRedirect;

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
