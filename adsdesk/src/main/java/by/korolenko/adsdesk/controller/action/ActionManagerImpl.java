package by.korolenko.adsdesk.controller.action;

import by.korolenko.adsdesk.service.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Sergei Korolenko
 * @version 1.0
 */
public class ActionManagerImpl implements ActionManager {

    private ServiceFactory factory;

    ActionManagerImpl(ServiceFactory factory) {
        this.factory = factory;
    }

    @Override
    public String execute(Action action, HttpServletRequest req,
                          HttpServletResponse resp) {
        action.setFactory(factory);
        return action.execute(req, resp);
    }

    @Override
    public void close() {
        factory.close();
    }
}
