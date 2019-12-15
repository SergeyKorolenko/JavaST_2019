package by.korolenko.adsdesk.controller.action;

import by.korolenko.adsdesk.service.ServiceFactory;

/**
 * @author Sergei Korolenko
 * @version 1.0
 */
public class ActionManagerFactory {

    private ActionManagerFactory() {
    }

    public static ActionManager getManager(ServiceFactory factory) {
        return new ActionManagerImpl(factory);
    }

}
