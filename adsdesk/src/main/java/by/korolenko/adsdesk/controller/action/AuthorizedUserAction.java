package by.korolenko.adsdesk.controller.action;

import by.korolenko.adsdesk.bean.enums.Role;

abstract public class AuthorizedUserAction extends Action {

    public AuthorizedUserAction() {
        getAllowRoles().add(Role.USER);
    }
}
