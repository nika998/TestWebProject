package it.engineering.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.engineering.web.actionfactory.ActionFactory;
import it.engineering.web.actions.AbstractAction;
import it.engineering.web.domain.User;


public class ApplicationController {
	public String processRequest(HttpServletRequest request, HttpServletResponse response) {
		
		String method = request.getMethod();
		String path = request.getPathInfo();
		User loginUser = (User) request.getSession().getAttribute("loginUser");
		
		AbstractAction action = ActionFactory.createAction(method, path, loginUser);
		
		return action.executeRequest(request, response);
	}

}
