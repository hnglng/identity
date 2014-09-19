package com.pact.identity.presentation.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by apple on 6/26/14.
 */
@Controller
@RequestMapping({"/", "/home"})
public class HomeController {
    private static final String HOME_PAGE = "homepage/home";


    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView showHomePage(HttpServletRequest request, HttpServletResponse response) {

        Map<String, Object> models = new HashMap<String, Object>();
        models.put("home", new Object());

        return new ModelAndView(HOME_PAGE, models);
    }

    @RequestMapping(value = "home", method = RequestMethod.GET)
    public ModelAndView show(HttpServletRequest request, HttpServletResponse response) {

        Map<String, Object> models = new HashMap<String, Object>();
        models.put("home", new Object());

        return new ModelAndView(HOME_PAGE, models);
    }
}
