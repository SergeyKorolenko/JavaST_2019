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
    private String name;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFactory(ServiceFactory factory) {
        this.factory = factory;
    }

    public abstract String execute(HttpServletRequest req,
                                   HttpServletResponse resp);

}
