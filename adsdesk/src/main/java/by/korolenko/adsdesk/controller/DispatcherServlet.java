package by.korolenko.adsdesk.controller;

import by.korolenko.adsdesk.bean.Category;
import by.korolenko.adsdesk.bean.enums.EntityType;
import by.korolenko.adsdesk.dao.factory.WrapperConnectionFactoryImpl;
import by.korolenko.adsdesk.dao.pool.ConnectionPool;
import by.korolenko.adsdesk.service.CategoryService;
import by.korolenko.adsdesk.service.ServiceFactory;
import by.korolenko.adsdesk.service.factory.ServiceFactoryImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

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
        ServiceFactory factory = new ServiceFactoryImpl(new WrapperConnectionFactoryImpl());
        CategoryService categoryService = factory.createService(EntityType.CATEGORY);
        List<Category> list = categoryService.findAll();
        req.setAttribute("lst", list);
        getServletContext().getRequestDispatcher("/WEB-INF/jsp/category/list.jsp").forward(req, resp);
    }

    @Override
    public void destroy() {
        ConnectionPool.getInstance().closePool();
    }
}
