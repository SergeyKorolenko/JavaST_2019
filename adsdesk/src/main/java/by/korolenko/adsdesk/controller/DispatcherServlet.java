package by.korolenko.adsdesk.controller;

import by.korolenko.adsdesk.controller.action.Action;
import by.korolenko.adsdesk.controller.action.ActionManager;
import by.korolenko.adsdesk.controller.action.ActionManagerFactory;
import by.korolenko.adsdesk.dao.factory.TransactionFactoryImpl;
import by.korolenko.adsdesk.dao.pool.ConnectionPool;
import by.korolenko.adsdesk.service.ServiceFactory;
import by.korolenko.adsdesk.service.factory.ServiceFactoryImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Sergei Korolenko
 * @version 1.0
 */
@MultipartConfig
public final class DispatcherServlet extends HttpServlet {

    private static final String COMMON_RELATIVE_PATH = "/WEB-INF/jsp";

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
        ActionManager actionManager = ActionManagerFactory.
                getManager(getFactory());
        String pagePart = actionManager.execute(action, request, response);
        actionManager.close();
        if (action.isRedirect() && pagePart != null) {
            if (action.isHeader()) {
                response.sendRedirect(pagePart);
            } else {
                String redirectUri = request.getContextPath() + pagePart;
                response.sendRedirect(redirectUri);
            }
        } else {
            getServletContext().getRequestDispatcher(COMMON_RELATIVE_PATH + pagePart).
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
