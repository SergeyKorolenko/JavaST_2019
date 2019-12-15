package by.korolenko.adsdesk.controller.filter;

import by.korolenko.adsdesk.bean.User;
import by.korolenko.adsdesk.bean.enums.Role;
import by.korolenko.adsdesk.controller.action.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author Sergei Korolenko
 * @version 1.0
 */
public class SecurityFilter implements Filter {

    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain filterChain)
            throws IOException, ServletException {
        if (request instanceof HttpServletRequest) {
            HttpServletRequest httpServletRequest = (HttpServletRequest) request;
            Action action = (Action) httpServletRequest.getAttribute("action");
            HttpSession session = httpServletRequest.getSession(false);
            User user = null;
            if (session != null) {
                user = (User) session.getAttribute("authorizedUser");
            }
            boolean isGo = false;
            if (user != null && (action instanceof AuthorizedUserAction
                    || action instanceof AllUserAction)
                    && (user.getRole() == Role.USER
                    || user.getRole() == Role.ADMINISTRATOR)) {
                isGo = true;
            }
            if (user != null && action instanceof UserAction
                    && user.getRole() == Role.USER) {
                isGo = true;
            }
            if (user != null && action instanceof AdminAction
                    && user.getRole() == Role.ADMINISTRATOR) {
                isGo = true;
            }
            if (user == null && action instanceof AllUserAction) {
                LOGGER.info("USER ROLE: null");
                isGo = true;
            }
            if (isGo) {
                filterChain.doFilter(request, response);
            } else {
                request.getServletContext().
                        getRequestDispatcher("/WEB-INF/jsp/error.jsp").
                        forward(request, response);
            }
        }
    }

    @Override
    public void destroy() {
    }
}
