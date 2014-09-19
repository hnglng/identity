package com.pact.identity.presentation.filter;

import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by apple on 6/26/14.
 */
public class LoginFilter implements Filter {
    private final static Logger logger = Logger.getLogger(LoginFilter.class);
    //private final static String USER_LOGIN_URI = "/user/login";
    //private final static String USER_LOGIN_URI_PATTERN = "/hotel/search";
    private final static String USER_LOGIN_URI = "/home";

    @Override
    public void destroy() {}

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        /*
        HttpServletRequest rq = (HttpServletRequest) request;

        if (isAuthenticationRequired(rq)) {
            Object obj = rq.getSession().getAttribute(SessionConst.LOGIN_USER_ATTR);
            if (obj == null) {
                HttpServletResponse rs = (HttpServletResponse) response;
                rs.sendRedirect(getLoginUri(rq));
            }
        }
          */

        chain.doFilter(request, response);

    }

    private boolean isAuthenticationRequired(HttpServletRequest request) {

        String uri = request.getRequestURI();
        String loginUri = getLoginUri(request);

        // Todo: Remove from code base after steady state.
        logger.debug( "uri >>> " + uri);

        if (uri.contains("register") || uri.equals(loginUri)) {
            return false;
        }

        // Todo: the check should be removed.
        if (uri.endsWith(".css")||uri.endsWith(".js")) {
            return false;
        }
        return true;
    }

    private String getLoginUri(HttpServletRequest request) {

        return request.getContextPath() + USER_LOGIN_URI;
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

}

