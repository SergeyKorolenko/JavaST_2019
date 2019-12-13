package by.korolenko.adsdesk.controller.action;

import by.korolenko.adsdesk.bean.User;
import by.korolenko.adsdesk.bean.enums.Role;
import by.korolenko.adsdesk.service.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashSet;
import java.util.Set;

public abstract class Action {

    private Set<Role> allowRoles = new HashSet<>();
    private User authorizedUser;
    private String actionName;
    private String uri;
    private boolean isRedirect;

    public boolean isRedirect() {
        return isRedirect;
    }

    public void setRedirect(boolean redirect) {
        isRedirect = redirect;
    }

    protected ServiceFactory factory;

    public Set<Role> getAllowRoles() {
        return allowRoles;
    }

    public User getAuthorizedUser() {
        return authorizedUser;
    }

    public void setAuthorizedUser(User authorizedUser) {
        this.authorizedUser = authorizedUser;
    }

    public String getActionName() {
        return actionName;
    }

    public void setActionName(String actionName) {
        this.actionName = actionName;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public void setFactory(ServiceFactory factory) {
        this.factory = factory;
    }

    public abstract String execute(HttpServletRequest req,
                                   HttpServletResponse resp);

}
