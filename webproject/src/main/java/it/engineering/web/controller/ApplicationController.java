package it.engineering.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.engineering.web.actionfactory.ActionFactory;
import it.engineering.web.actions.AbstractAction;
import it.engineering.web.domain.User;

@Component
public class ApplicationController {
	
	@Autowired
	private ActionFactory actionFactory;
	
	public String processRequest(HttpServletRequest request, HttpServletResponse response) {
		
		String method = request.getMethod();
		String path = request.getPathInfo();
		User loginUser = (User) request.getSession().getAttribute("loginUser");
		
		AbstractAction action = actionFactory.createAction(method, path, loginUser);
		
		return action.executeRequest(request, response);
	}

}
