package it.engineering.web.actions.factory;

import it.engineering.web.actions.AbstractAction;
import it.engineering.web.actions.login.ActionLogin;
import it.engineering.web.actions.login.ActionLogout;
import it.engineering.web.actions.manufacturer.ActionManufacturers;
<<<<<<< Updated upstream
=======
import it.engineering.web.actions.manufacturer.ActionManufacturersAdd;
import it.engineering.web.actions.manufacturer.ActionManufacturersDelete;
import it.engineering.web.actions.manufacturer.ActionManufacturersEdit;
import it.engineering.web.actions.manufacturer.ActionManufacturersEditPIB;
import it.engineering.web.actions.manufacturer.ActionViewManufacturer;
>>>>>>> Stashed changes
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
<<<<<<< Updated upstream
=======
		case WebConstants.PATH_MANUFACTURERS_ADD:
			//proveriti uspesnost logovanja
			action = new ActionAddManufacturer();
			break;
		case WebConstants.PATH_MANUFACTURERS_ADD_CONFIRM:
			//proveriti uspesnost logovanja
			action = new ActionManufacturersAdd();
			break;
		case WebConstants.PATH_MANUFACTURERS_EDIT:
			//proveriti uspesnost logovanja
			action = new ActionEditManufacturer();
			break;
		case WebConstants.PATH_MANUFACTURERS_EDIT_CONFIRM:
			//proveriti uspesnost logovanja
			action = new ActionManufacturersEdit();
			break;
		case WebConstants.PATH_MANUFACTURERS_EDIT_CONFIRM_PIB:
			//proveriti uspesnost logovanja
			action = new ActionManufacturersEditPIB();
			break;
		case WebConstants.PATH_MANUFACTURERS_DELETE:
			//proveriti uspesnost logovanja
			action = new ActionDeleteManufacturer();
			break;
		case WebConstants.PATH_MANUFACTURERS_DELETE_CONFIRM:
			//proveriti uspesnost logovanja
			action = new ActionManufacturersDelete();
			break;
		case WebConstants.PATH_MANUFACTURERS_VIEW:
			//proveriti uspesnost logovanja
			action = new ActionViewManufacturer();
			break;
>>>>>>> Stashed changes
			
		default:
			break;
		}
		
		
		return action;
	}

}
