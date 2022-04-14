package it.engineering.web.actions.manufacturer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.engineering.web.actions.AbstractAction;
import it.engineering.web.constants.WebConstants;
import it.engineering.web.storage.ManufacturersStorage;

public class ActionManufacturers extends AbstractAction{

	@Override
	public String executeRequest(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("manufacturers", ManufacturersStorage.getInstance().getAll());
		return WebConstants.PAGE_MANUFACTURERS;
	}

}
