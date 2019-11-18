package by.korolenko.adsdesk.controller;

import by.korolenko.adsdesk.dao.pool.ConnectionPool;
import by.korolenko.adsdesk.service.CategoryService;
import by.korolenko.adsdesk.service.impl.CategoryServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
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
@MultipartConfig
public final class DispatcherServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        ConnectionPool.getInstance();
    }

    @Override
    protected void doGet(final HttpServletRequest req,
                         final HttpServletResponse resp)
            throws ServletException, IOException {
        process(req, resp);
    }

    @Override
    protected void doPost(final HttpServletRequest req,
                          final HttpServletResponse resp)
            throws ServletException, IOException {
        process(req, resp);
    }

    private void process(final HttpServletRequest req,
                         final HttpServletResponse resp)
            throws ServletException, IOException {
        /*CategoryService categoryService = new CategoryServiceImpl();
        req.setAttribute("lst", categoryService.findAll());
        RequestDispatcher requestDispatcher = getServletContext().
                getRequestDispatcher("WEB-INF/jsp/category/list.jsp");
        requestDispatcher.forward(req, resp);*/
    }

    @Override
    public void destroy() {
        ConnectionPool.getInstance().closePool();
    }
}
