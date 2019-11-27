package by.korolenko.adsdesk.controller.action;

import by.korolenko.adsdesk.service.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ActionManagerImpl implements ActionManager {
    private ServiceFactory factory;

    public ActionManagerImpl(ServiceFactory factory) {
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
