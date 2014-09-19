package com.pact.identity.presentation.controller;

import com.pact.identity.presentation.model.UserSignInInfo;
import com.pact.identity.presentation.model.UserSignUpInfo;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.util.UrlUtils;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by apple on 7/24/14.
 */
@Controller
public class LoginController {
    private static final String LOGIN_PAGE = "identity/login";
    private static final String HOME_PAGE = "homepage/home";
    private static final String AUTHENTICATION_FAILURE_PAGE = "identity/authentication-failure";
    private static final String SIGNUP_PAGE = "identity/signup";
    private static final String NOTIFICATION_PAGE = "identity/notification";
    private static final String ABOUT_PAGE = "common/about";

    protected final Log logger = LogFactory.getLog(getClass());
    private String targetUrlParameter = null;
    private String defaultTargetUrl = "/";
    private boolean alwaysUseDefaultTargetUrl = false;
    private boolean useReferer = false;
    private boolean contextRelative;


    @RequestMapping(method = RequestMethod.GET)
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        //String redirectUrl = calculateRedirectUrl(request.getContextPath(), url);
        //redirectUrl = response.encodeRedirectURL(redirectUrl);

        String redirectUrl = "/login";

        if (logger.isDebugEnabled()) {
            logger.debug("Redirecting to '" + redirectUrl + "'");
        }

        response.sendRedirect(redirectUrl);
    }


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(HttpServletRequest servletRequest, HttpServletResponse servletResponse)
            throws Exception {

        Map<String, Object> models = new HashMap<String, Object>();
        return new ModelAndView(LOGIN_PAGE, models);
    }

    @RequestMapping(value = "/signin", method = RequestMethod.POST)
    public ModelAndView signin(@ModelAttribute UserSignInInfo userSignInInfo, BindingResult result,
                               HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
            throws Exception {

        String username = userSignInInfo.getUsername();

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        } else {
            username = principal.toString();
        }

        Map<String, Object> models = new HashMap<String, Object>();
        models.put("userSignInInfo", userSignInInfo);
        return new ModelAndView(HOME_PAGE, models);
    }

    @RequestMapping(value = "/authentication-failure", method = RequestMethod.GET)
    public ModelAndView authenticationFailure(HttpServletRequest servletRequest, HttpServletResponse servletResponse)
    {
        Map<String, Object> models = new HashMap<String, Object>();
        return new ModelAndView(AUTHENTICATION_FAILURE_PAGE, models);
    }

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public ModelAndView signup(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
            throws Exception {

        String username;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        } else {
            username = principal.toString();
        }

        if (SecurityContextHolder.getContext().getAuthentication().isAuthenticated()){

        }

        return new ModelAndView(SIGNUP_PAGE);
    }



    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public ModelAndView signupOnSubmit(@ModelAttribute UserSignUpInfo userSignUpInfo, BindingResult result,
        HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {

        String username = userSignUpInfo.getUsername();

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        } else {
            username = principal.toString();
        }

        return new ModelAndView(SIGNUP_PAGE);
    }

    @RequestMapping(value = "/about", method = RequestMethod.GET)
    public ModelAndView signupOnSubmit(
            HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        return new ModelAndView(ABOUT_PAGE);
    }


    private String calculateRedirectUrl(String contextPath, String url) {
        if (!UrlUtils.isAbsoluteUrl(url)) {
            if (contextRelative) {
                return url;
            } else {
                return contextPath + url;
            }
        }

        // Full URL, including http(s)://

        if (!contextRelative) {
            return url;
        }

        // Calculate the relative URL from the fully qualified URL, minus the last
        // occurrence of the scheme and base context.
        url = url.substring(url.lastIndexOf("://") + 3); // strip off scheme
        url = url.substring(url.indexOf(contextPath) + contextPath.length());

        if (url.length() > 1 && url.charAt(0) == '/') {
            url = url.substring(1);
        }

        return url;
    }

    protected String determineTargetUrl(HttpServletRequest request, HttpServletResponse response) {
        if (isAlwaysUseDefaultTargetUrl()) {
            return defaultTargetUrl;
        }

        // Check for the parameter and use that if available
        String targetUrl = null;

        if (targetUrlParameter != null  ) {
            targetUrl = request.getParameter(targetUrlParameter);

            if (StringUtils.hasText(targetUrl)) {
                logger.debug("Found targetUrlParameter in request: " + targetUrl);

                return targetUrl;
            }
        }

        if (useReferer && !StringUtils.hasLength(targetUrl)) {
            targetUrl = request.getHeader("Referer");
            logger.debug("Using Referer header: " + targetUrl);
        }

        if (!StringUtils.hasText(targetUrl)) {
            targetUrl = defaultTargetUrl;
            logger.debug("Using default Url: " + targetUrl);
        }

        return targetUrl;
    }

    protected boolean isAlwaysUseDefaultTargetUrl() {
        return alwaysUseDefaultTargetUrl;
    }

}
