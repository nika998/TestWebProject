package it.engineering.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.engineering.web.actions.AbstractAction;
import it.engineering.web.actions.factory.ActionFactory;


public class ApplicationController {
	public String processRequest(HttpServletRequest request, HttpServletResponse response) {
		
		String method = request.getMethod();
		String path = request.getPathInfo();
		
		AbstractAction action = ActionFactory.createAction(method, path);
		
		return action.executeRequest(request, response);
	}

}
