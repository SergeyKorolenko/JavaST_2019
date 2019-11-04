package by.korolenko.xml.controller;

import by.korolenko.xml.controller.command.Command;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 29.10.2019
 */
@WebServlet("/controller")
@MultipartConfig
public class Controller extends HttpServlet {

    /**
     * This is command provider which contains map of commands.
     */
    private final CommandProvider provider = new CommandProvider();
    /**
     * This is the get method.
     *
     * @param request  request
     * @param response response
     * @throws IOException      io exception
     * @throws ServletException servlet exception
     */
    @Override
    protected void doGet(final HttpServletRequest request,
                         final HttpServletResponse response)
            throws IOException, ServletException {
        processRequest(request, response);
    }

    /**
     * This is the post method.
     *
     * @param request  request
     * @param response response
     * @throws IOException      io exception
     * @throws ServletException servlet exception
     */
    @Override
    protected void doPost(final HttpServletRequest request,
                          final HttpServletResponse response)
            throws IOException, ServletException {
        processRequest(request, response);
    }

    private void processRequest(final HttpServletRequest request,
                                final HttpServletResponse response)
            throws IOException, ServletException {
        try {

            String fileName = readFilePath(request);
            String commandName = request.getParameter("parser").
                    toUpperCase();
            Command command = provider.getCommand(commandName);
            request.setAttribute("lst", command.execute(fileName,
                    commandName));
            RequestDispatcher requestDispatcher = getServletContext().
                    getRequestDispatcher("/jsp/gemlist.jsp");
            requestDispatcher.forward(request, response);
        } catch (IllegalArgumentException e) {
            RequestDispatcher requestDispatcher = getServletContext().
                    getRequestDispatcher("/jsp/error.jsp");
            requestDispatcher.forward(request, response);
        }
    }

    private String readFilePath(final HttpServletRequest request)
            throws IOException, ServletException {
        String uploadPath = getServletContext().getRealPath("") + "test";
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }
        String fileName = null;
        Part part = request.getPart("file");
        fileName = getFileName(part);
        part.write(uploadPath + File.separator + fileName);
        return uploadPath + File.separator + fileName;
    }

    private String getFileName(final Part part) {
        for (String content : part.getHeader("content-disposition").
                split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(content.indexOf('=') + 1).trim()
                        .replace("\"", "");
            }
        }
        return null;
    }
}
