package com.pact.identity.presentation.controller;

import com.pact.identity.domain.entities.User;
import com.pact.identity.presentation.util.SessionConst;

import javax.servlet.http.HttpServletRequest;


public abstract class AbstractController {

	protected Object getSessionAttr(HttpServletRequest request, String attrName) {
		return request.getSession().getAttribute(attrName);
	}

	protected User getLoginUser(HttpServletRequest request) {
		Object obj = getSessionAttr(request, SessionConst.LOGIN_USER_ATTR);
		if (obj == null) {
			return null;
		} else {
			User user = (User) obj;
			return user;
		}
	}
	

}
