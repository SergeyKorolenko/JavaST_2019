package by.korolenko.adsdesk.controller.filter;

import by.korolenko.adsdesk.controller.action.Action;
import by.korolenko.adsdesk.controller.action.impl.alluser.*;
import by.korolenko.adsdesk.controller.action.impl.authorized.*;
import by.korolenko.adsdesk.controller.action.impl.user.*;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author Sergei Korolenko
 * @version 1.0
 */
public class ActionFromUriFilter implements Filter {

    private Action createActionByUri(String uri) {
        switch (uri) {
            case "/login":
                return new LoginAction();
            case "/register":
                return new RegisterAction();
            case "/logout":
                return new LogoutAction();
            case "/search/ads/category":
                return new SearchAdsByCategoryAction();
            case "/search/ads/subcategory":
                return new SearchAdsBySubcategoryAction();
            case "/ads/detail":
                return new AdsDetailAction();
            case "/ads/sort":
                return new AdsSortAction();
            case "/user/update":
                return new UserInfoUpdateAction();
            case "/user/profile":
                return new UserProfileAction();
            case "/user/change/password":
                return new ChangePasswordAction();
            case "/page/login":
                return new LoginPageAction();
            case "/page/register":
                return new RegisterPageAction();
            case "/ads/filter":
                return new AdsFilterAction();
            case "/ads/delete":
                return new AdsDeleteAction();
            case "/search/substring":
                return new SearchAdsBySubstringAction();
            case "/add/comment":
                return new AddCommentAction();
            case "/page/ads/add":
                return new AddAdsPageAction();
            case "/ads/add":
                return new AddAdsAction();
            case "/ads/activate":
                return new AdsActivateAction();
            case "/ads/deactivate":
                return new AdsDeactivateAction();
            default:
                return new MainAction();
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
            httpRequest.setAttribute("action", action);
            filterChain.doFilter(request, response);
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
