package it.engineering.web.actions.factory;

import it.engineering.web.actions.AbstractAction;
import it.engineering.web.actions.login.ActionLogin;
import it.engineering.web.actions.login.ActionLogout;
import it.engineering.web.actions.manufacturer.ActionManufacturers;
import it.engineering.web.constants.WebConstants;

public class ActionFactory {
	
	public static AbstractAction createAction(String method, String path) {
		System.out.println(path);
		AbstractAction action = null;
		
		switch (path) {
		case WebConstants.PATH_LOGIN:
			//proveriti uspesnost logovanja
			action = new ActionLogin();
			break;
		case WebConstants.PATH_LOGOUT:
			//proveriti uspesnost logovanja
			action = new ActionLogout();
			break;
		case WebConstants.PATH_MANUFACTURERS:
			//proveriti uspesnost logovanja
			action = new ActionManufacturers();
			break;
			
		default:
			break;
		}
		
		
		return action;
	}

}
