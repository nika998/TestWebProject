package it.engineering.web.actionfactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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

@Component
public class ActionFactory {
	
	private ActionLogout actionLogout;
	private ActionLogin actionLogin;
	private ActionRegister actionRegister;
	private ActionRegisterSubmit actionRegisterSubmit;
	private ActionManufacturers actionManufacturers;
	private ActionAddManufacturer actionAddManufacturer;
	private ActionManufacturersAdd actionManufacturersAdd;
	private ActionEditManufacturer actionEditManufacturer;
	private ActionManufacturersEdit actionManufacturersEdit;
	private ActionManufacturersEditPIB actionManufacturersEditPIB;
	private ActionManufacturersEditConfirm actionManufacturersEditConfirm;
	private ActionDeleteManufacturer actionDeleteManufacturer;
	private ActionManufacturersDelete actionManufacturersDelete;
	private ActionManufacturersDeleteTable actionManufacturersDeleteTable;
	private ActionManufacturersDeleteConfirm actionManufacturersDeleteConfirm;
	private ActionViewManufacturer actionViewManufacturer;
	
	@Autowired
	public ActionFactory(ActionLogout actionLogout, ActionLogin actionLogin, ActionRegister actionRegister,
			ActionRegisterSubmit actionRegisterSubmit, ActionManufacturers actionManufacturers,
			ActionAddManufacturer actionAddManufacturer, ActionManufacturersAdd actionManufacturersAdd,
			ActionEditManufacturer actionEditManufacturer, ActionManufacturersEdit actionManufacturersEdit,
			ActionManufacturersEditPIB actionManufacturersEditPIB,
			ActionManufacturersEditConfirm actionManufacturersEditConfirm,
			ActionDeleteManufacturer actionDeleteManufacturer, ActionManufacturersDelete actionManufacturersDelete,
			ActionManufacturersDeleteTable actionManufacturersDeleteTable,
			ActionManufacturersDeleteConfirm actionManufacturersDeleteConfirm,
			ActionViewManufacturer actionViewManufacturer) {
		super();
		this.actionLogout = actionLogout;
		this.actionLogin = actionLogin;
		this.actionRegister = actionRegister;
		this.actionRegisterSubmit = actionRegisterSubmit;
		this.actionManufacturers = actionManufacturers;
		this.actionAddManufacturer = actionAddManufacturer;
		this.actionManufacturersAdd = actionManufacturersAdd;
		this.actionEditManufacturer = actionEditManufacturer;
		this.actionManufacturersEdit = actionManufacturersEdit;
		this.actionManufacturersEditPIB = actionManufacturersEditPIB;
		this.actionManufacturersEditConfirm = actionManufacturersEditConfirm;
		this.actionDeleteManufacturer = actionDeleteManufacturer;
		this.actionManufacturersDelete = actionManufacturersDelete;
		this.actionManufacturersDeleteTable = actionManufacturersDeleteTable;
		this.actionManufacturersDeleteConfirm = actionManufacturersDeleteConfirm;
		this.actionViewManufacturer = actionViewManufacturer;
	}

	public AbstractAction createAction(String method, String path, User loginUser) {
		System.out.println(path);
		AbstractAction action = null;
        if(loginUser == null && !path.equals(WebConstants.PATH_LOGIN) && !path.equals(WebConstants.PATH_REGISTER)
        		&& !path.equals(WebConstants.PATH_REGISTER_SUBMIT)) {
			return actionLogout;
        }
		switch (path) {
		case WebConstants.PATH_LOGIN:;
			return actionLogin;
		case WebConstants.PATH_LOGOUT:
			return actionLogout;
		case WebConstants.PATH_REGISTER:
			return actionRegister;
		case WebConstants.PATH_REGISTER_SUBMIT:
			return actionRegisterSubmit;
		case WebConstants.PATH_MANUFACTURERS:
			return actionManufacturers;
		case WebConstants.PATH_MANUFACTURERS_ADD:
			return actionAddManufacturer;
		case WebConstants.PATH_MANUFACTURERS_ADD_CONFIRM:
			return actionManufacturersAdd;
		case WebConstants.PATH_MANUFACTURERS_NAV_EDIT:
			return actionEditManufacturer;
		case WebConstants.PATH_MANUFACTURERS_PAGE_EDIT:
			return actionManufacturersEdit;
		case WebConstants.PATH_MANUFACTURERS_EDIT_CONFIRM_PIB:
			return actionManufacturersEditPIB;
		case WebConstants.PATH_MANUFACTURERS_PAGE_EDIT_CONFIRM:
			return actionManufacturersEditConfirm;
		case WebConstants.PATH_MANUFACTURERS_NAV_DELETE:
			return actionDeleteManufacturer;
		case WebConstants.PATH_MANUFACTURERS_PAGE_DELETE:
			return actionManufacturersDelete;
		case WebConstants.PATH_MANUFACTURERS_TABLE_DELETE:
			return actionManufacturersDeleteTable;
		case WebConstants.PATH_MANUFACTURERS_PAGE_DELETE_CONFIRM:
			return actionManufacturersDeleteConfirm;
		case WebConstants.PATH_MANUFACTURERS_VIEW:
			return actionViewManufacturer;

		default:
			break;
		}

		return null;
	}

}
