package it.engineering.web.actions.factory;

import it.engineering.web.actions.AbstractAction;
import it.engineering.web.actions.login.ActionLogin;
import it.engineering.web.actions.login.ActionLogout;
import it.engineering.web.actions.login.ActionRegister;
import it.engineering.web.actions.login.ActionRegisterSubmit;
import it.engineering.web.actions.manufacturer.ActionManufacturers;
import it.engineering.web.actions.manufacturer.add.ActionAddManufacturer;
import it.engineering.web.actions.manufacturer.add.ActionManufacturersAdd;
import it.engineering.web.actions.manufacturer.delete.ActionDeleteManufacturer;
import it.engineering.web.actions.manufacturer.delete.ActionManufacturersDelete;
import it.engineering.web.actions.manufacturer.delete.ActionManufacturersDeleteConfirm;
import it.engineering.web.actions.manufacturer.delete.ActionManufacturersDeleteTable;
import it.engineering.web.actions.manufacturer.edit.ActionEditManufacturer;
import it.engineering.web.actions.manufacturer.edit.ActionManufacturersEdit;
import it.engineering.web.actions.manufacturer.edit.ActionManufacturersEditConfirm;
import it.engineering.web.actions.manufacturer.edit.ActionManufacturersEditPIB;
import it.engineering.web.actions.manufacturer.edit.ActionViewManufacturer;
import it.engineering.web.constants.WebConstants;
import it.engineering.web.domain.User;

public class ActionFactory {

	public static AbstractAction createAction(String method, String path, User loginUser) {
		System.out.println(path);
		AbstractAction action = null;
        if(loginUser == null && !path.equals(WebConstants.PATH_LOGIN) && !path.equals(WebConstants.PATH_REGISTER)
        		&& !path.equals(WebConstants.PATH_REGISTER_SUBMIT)) {
        	action = new ActionLogout();
			return action;
        }
		switch (path) {
		case WebConstants.PATH_LOGIN:
			action = new ActionLogin();
			break;
		case WebConstants.PATH_LOGOUT:
			action = new ActionLogout();
			break;
		case WebConstants.PATH_REGISTER:
			action = new ActionRegister();
			break;
		case WebConstants.PATH_REGISTER_SUBMIT:
			action = new ActionRegisterSubmit();
			break;
		case WebConstants.PATH_MANUFACTURERS:
			action = new ActionManufacturers();
			break;
		case WebConstants.PATH_MANUFACTURERS_ADD:
			action = new ActionAddManufacturer();
			break;
		case WebConstants.PATH_MANUFACTURERS_ADD_CONFIRM:
			action = new ActionManufacturersAdd();
			break;
		case WebConstants.PATH_MANUFACTURERS_NAV_EDIT:
			action = new ActionEditManufacturer();
			break;
		case WebConstants.PATH_MANUFACTURERS_PAGE_EDIT:
			action = new ActionManufacturersEdit();
			break;
		case WebConstants.PATH_MANUFACTURERS_EDIT_CONFIRM_PIB:
			action = new ActionManufacturersEditPIB();
			break;
		case WebConstants.PATH_MANUFACTURERS_PAGE_EDIT_CONFIRM:
			action = new ActionManufacturersEditConfirm();
			break;
		case WebConstants.PATH_MANUFACTURERS_NAV_DELETE:
			action = new ActionDeleteManufacturer();
			break;
		case WebConstants.PATH_MANUFACTURERS_PAGE_DELETE:
			action = new ActionManufacturersDelete();
			break;
		case WebConstants.PATH_MANUFACTURERS_TABLE_DELETE:
			action = new ActionManufacturersDeleteTable();
			break;
		case WebConstants.PATH_MANUFACTURERS_PAGE_DELETE_CONFIRM:
			action = new ActionManufacturersDeleteConfirm();
			break;
		case WebConstants.PATH_MANUFACTURERS_VIEW:
			action = new ActionViewManufacturer();
			break;

		default:
			break;
		}

		return action;
	}

}
