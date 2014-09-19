package com.pact.identity.presentation.controller;

import com.pact.identity.domain.entities.User;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by apple on 7/29/14.
 */
public class ResourceController {
    private static final String REGISTERED_PAGE = "user/registered";

    protected final Log logger = LogFactory.getLog(getClass());


    //@Autowired
    //IUserService userService;


    @RequestMapping(method = RequestMethod.GET)
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String redirectUrl = "/login";

        if (logger.isDebugEnabled()) {
            logger.debug("Redirecting to '" + redirectUrl + "'");
        }

        response.sendRedirect(redirectUrl);
    }

    @RequestMapping(value = "retrieve", method = RequestMethod.GET)
    public ModelAndView retrieve(User user, HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map<String, Object> model = new HashMap<String, Object>();
        return new ModelAndView(REGISTERED_PAGE, model);
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ModelAndView add(User user, HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map<String, Object> model = new HashMap<String, Object>();
        return new ModelAndView(REGISTERED_PAGE, model);
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public ModelAndView update(User user, HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map<String, Object> model = new HashMap<String, Object>();
        return new ModelAndView(REGISTERED_PAGE, model);
    }

    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public ModelAndView delete(User user, HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map<String, Object> model = new HashMap<String, Object>();
        return new ModelAndView(REGISTERED_PAGE, model);
    }

}
