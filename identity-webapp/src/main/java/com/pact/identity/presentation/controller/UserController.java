package com.pact.identity.presentation.controller;

import com.pact.identity.domain.entities.User;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import sun.misc.BASE64Encoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {
    private static final String REGISTERED_PAGE = "user/registered";
    private static final String USER_ADMIN_PAGE = "identity/user-admin";

    protected final Log logger = LogFactory.getLog(getClass());

    //@Autowired
    //IUserService userService;

    /*
    @RequestMapping(method = RequestMethod.GET)
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String redirectUrl = "/login";

        if (logger.isDebugEnabled()) {
            logger.debug("Redirecting to '" + redirectUrl + "'");
        }

        response.sendRedirect(redirectUrl);
    }
    */

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView show(User user, HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map<String, Object> model = new HashMap<String, Object>();
        return new ModelAndView(USER_ADMIN_PAGE, model);
    }

    @RequestMapping(value = "retrieve", method = RequestMethod.GET)
    public ModelAndView retrieve(User user, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        Map<String, Object> model = new HashMap<String, Object>();
        return new ModelAndView(REGISTERED_PAGE, model);
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ModelAndView add(User user, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        Map<String, Object> model = new HashMap<String, Object>();
        return new ModelAndView(REGISTERED_PAGE, model);
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public ModelAndView update(User user, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        Map<String, Object> model = new HashMap<String, Object>();
        return new ModelAndView(REGISTERED_PAGE, model);
    }

    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public ModelAndView delete(User user, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        Map<String, Object> model = new HashMap<String, Object>();
        return new ModelAndView(REGISTERED_PAGE, model);
    }

    private String encode(String origin) throws Exception {
        if (origin == null) {
            return null;
        }

        String value = null;
        try {
            BASE64Encoder baseEncoder = new BASE64Encoder();
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            value = baseEncoder.encode(md5.digest(origin.getBytes("utf-8")));
        } catch (Exception ex) {
            throw ex;
        }
        return value;
    }
}
