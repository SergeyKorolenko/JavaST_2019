package by.korolenko.xml.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 29.10.2019
 */
@WebServlet("/parser")
public class Controller extends HttpServlet {

    /**
     * This is the get method.
     *
     * @param request  request
     * @param response responce
     * @throws IOException      io exception
     * @throws ServletException servlet exception
     */
    @Override
    public void doGet(final HttpServletRequest request,
                      final HttpServletResponse response)
            throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Data from xml</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>HELLO</h1>");
        out.println("</body>");
        out.println("</html>");
    }
}
