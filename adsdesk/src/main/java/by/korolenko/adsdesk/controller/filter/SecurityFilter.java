package by.korolenko.adsdesk.controller.filter;

import javax.servlet.*;
import java.io.IOException;

public class SecurityFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain filterChain)
            throws IOException, ServletException {
        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {
    }
}
