package by.korolenko.adsdesk.controller.filter;

import by.korolenko.adsdesk.controller.action.Action;
import by.korolenko.adsdesk.controller.action.common.*;
import by.korolenko.adsdesk.controller.action.user.AdsDeleteAction;
import by.korolenko.adsdesk.controller.action.user.UserProfileAction;
import by.korolenko.adsdesk.controller.action.user.UserSaveAction;
import by.korolenko.adsdesk.controller.action.user.UserUpdateAction;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class ActionFromUriFilter implements Filter {

    private Action createActionByUri(String uri) {
        switch (uri) {
            case "/":
            case "/main":
                return new MainAction();
            case "/login":
                return new LoginAction();
            case "/register":
                return new RegisterAction();
            case "/logout":
                return new LogoutAction();
            case "/search/ads/category":
                return new SearchAdsByCategoryAction();
            case "/ads/detail":
                return new AdsDetailAction();
            case "/user/profile":
                return new UserProfileAction();
            case "/page/login":
                return new LoginPageAction();
            case "/page/register":
                return new RegisterPageAction();
            case "/ads/filter":
                return new AdsFilterAction();
            case "/user/update":
                return new UserUpdateAction();
            case "/user/save":
                return new UserSaveAction();
            case "/ads/delete":
                return new AdsDeleteAction();
            case "/search/substring":
                return new SearchAdsBySubstringAction();
            default:
                return null;
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response, FilterChain filterChain)
            throws IOException, ServletException {

        if (request instanceof HttpServletRequest) {
            HttpServletRequest httpRequest = (HttpServletRequest) request;
            String contextPath = httpRequest.getContextPath();
            String uri = httpRequest.getRequestURI();
            int beginAction = contextPath.length();
            int endAction = uri.lastIndexOf('.');
            String actionName;
            if (endAction >= 0) {
                actionName = uri.substring(beginAction, endAction);
            } else {
                actionName = uri.substring(beginAction);
            }
            Action action = createActionByUri(actionName);
            if (action != null) {
                action.setName(actionName);
                httpRequest.setAttribute("action", action);
                filterChain.doFilter(request, response);
            } else {
                httpRequest.getServletContext().
                        getRequestDispatcher("/WEB-INF/jsp/error.jsp").
                        forward(request, response);
            }
        } else {
            request.getServletContext().
                    getRequestDispatcher("/WEB-INF/jsp/error.jsp").
                    forward(request, response);
        }
    }

    @Override
    public void destroy() {
    }
}
