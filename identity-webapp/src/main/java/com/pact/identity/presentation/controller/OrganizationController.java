package com.pact.identity.presentation.controller;

import com.pact.identity.application.service.OrganizationService;
import com.pact.identity.domain.entities.Organization;
import com.pact.identity.presentation.helper.IHelper;
import com.pact.identity.presentation.helper.OrganizationHelper;
import com.pact.identity.presentation.model.OrganizationModel;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Bright Huang on 7/29/14.
 */
@Controller
@RequestMapping("/organization")
public class OrganizationController {
    protected final Log logger = LogFactory.getLog(getClass());
    private static final String ORGANIZATION_PAGE = "identity/organization";
    private static final String ORGANIZATION_LIST_PAGE = "identity/organization-list";
    private static final String ORGANIZATION_EDIT_PAGE = "identity/organization-edit";


    @Autowired
    private OrganizationService organizationService;

    @Autowired
    private OrganizationHelper organizationHelper;


    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView show(HttpServletRequest request, HttpServletResponse response) throws IOException {

        Map<String, Object> models = new HashMap<String, Object>();
        return new ModelAndView(ORGANIZATION_PAGE, models);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ModelAndView retrieve(@PathVariable("id") long id, HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        Organization organization = organizationService.getOrganizationById(id);

        OrganizationModel organizationModel = organizationHelper.toModel(organization);

        Map<String, Object> models = new HashMap<String, Object>();

        models.put("organizationModel", organizationModel);

        return new ModelAndView(ORGANIZATION_EDIT_PAGE, models);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ModelAndView retrieveAll( HttpServletRequest request, HttpServletResponse response)throws IOException {

        List<Organization> organizations = organizationService.allOfOrganization();

        List<OrganizationModel> organizationModels = organizationHelper.toModels(organizations);

        Map<String, Object> models = new HashMap<String, Object>();

        models.put("organizations", organizationModels);

        return new ModelAndView(ORGANIZATION_LIST_PAGE, models);
    }

    @RequestMapping(value = "/{id}/children", method = RequestMethod.GET)
    public @ResponseBody List<OrganizationModel> getChildrenByParentId(@PathVariable("id") long id,
                                                                  HttpServletRequest request,
                                                                  HttpServletResponse response){
        List<Organization> organizations = organizationService.findChildrenByParentId(id);

        List<OrganizationModel> organizationModels = organizationHelper.toModels(organizations);

        return organizationModels;
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public @ResponseBody Organization create(@Valid @ModelAttribute("organization") OrganizationModel organizationModel,
                                             BindingResult result, HttpServletRequest request,
                                             HttpServletResponse response)
            throws ServletRequestBindingException, IOException {

        if (result.hasErrors()){
            response.sendRedirect("/error");
        }

        Organization organization = organizationHelper.toEntity(organizationModel);
        organizationService.createOrganization(organization);


        response.setHeader("Location", "/organization/" + organization.getId());

        return organization;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public @ResponseBody Organization update(@PathVariable("id") long id, @Valid Organization organization,
                                             BindingResult result, HttpServletRequest request,
                                             HttpServletResponse response) throws IOException {
        if (result.hasErrors()){
            //throw new ServletRequestBindingException("create organization error.");
            response.sendRedirect("/error");
        }

        organizationService.saveOrganization(organization);
        response.setHeader("Location", "/organization/all");

        return organization;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") long id, @Valid Organization organization,
                               BindingResult result, HttpServletRequest request,
                               HttpServletResponse response) throws IOException {
        if (result.hasErrors()){
            //throw new ServletRequestBindingException("create organization error.");
            response.sendRedirect("/error");
        }

        organizationService.removeOrganization(organization);
        response.setHeader("Location", "/organization/all");

    }



}
