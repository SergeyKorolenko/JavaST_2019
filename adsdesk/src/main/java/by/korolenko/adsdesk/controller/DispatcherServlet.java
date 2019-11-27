package by.korolenko.adsdesk.controller;

import by.korolenko.adsdesk.controller.action.Action;
import by.korolenko.adsdesk.controller.action.ActionManager;
import by.korolenko.adsdesk.controller.action.ActionManagerFactory;
import by.korolenko.adsdesk.dao.factory.TransactionFactoryImpl;
import by.korolenko.adsdesk.dao.pool.ConnectionPool;
import by.korolenko.adsdesk.service.ServiceFactory;
import by.korolenko.adsdesk.service.factory.ServiceFactoryImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 14.11.2019
 */
@WebServlet("/controller")
public final class DispatcherServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        ConnectionPool.getInstance();
    }

    @Override
    protected void doGet(final HttpServletRequest request,
                         final HttpServletResponse response)
            throws ServletException, IOException {
        process(request, response);
    }

    @Override
    protected void doPost(final HttpServletRequest request,
                          final HttpServletResponse response)
            throws ServletException, IOException {
        process(request, response);
    }

    private void process(final HttpServletRequest request,
                         final HttpServletResponse response)
            throws ServletException, IOException {
        Action action = (Action) request.getAttribute("action");
        if (action != null) {
            ActionManager actionManager = ActionManagerFactory.
                    getManager(getFactory());
            String page = actionManager.execute(action, request, response);
            actionManager.close();
            getServletContext().getRequestDispatcher(page).
                    forward(request, response);
        } else {
            getServletContext().getRequestDispatcher("/WEB-INF/jsp/error.jsp").
                    forward(request, response);
        }
    }

    private ServiceFactory getFactory() {
        return new ServiceFactoryImpl(new TransactionFactoryImpl());
    }

    @Override
    public void destroy() {
        ConnectionPool.getInstance().closePool();
    }
}
