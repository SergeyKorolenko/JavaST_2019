package by.korolenko.adsdesk.controller.action.impl;

import by.korolenko.adsdesk.bean.enums.Role;
import by.korolenko.adsdesk.controller.action.Action;

abstract public class AdminAction extends Action {

    public AdminAction() {
        getAllowRoles().add(Role.ADMINISTRATOR);
    }
}
