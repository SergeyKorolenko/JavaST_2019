package by.korolenko.adsdesk.controller.action;

import by.korolenko.adsdesk.service.ServiceFactory;

public class ActionManagerFactory {

    public static ActionManager getManager(ServiceFactory factory) {
        return new ActionManagerImpl(factory);
    }

}
