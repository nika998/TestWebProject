package it.engineering.web.actions.manufacturer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.engineering.web.actions.AbstractAction;
import it.engineering.web.constants.WebConstants;
import it.engineering.web.service.ManufacturerService;
import it.engineering.web.service.implementation.ManufacturerServiceImplementation;

public class ActionManufacturers extends AbstractAction{
	
	private ManufacturerService manufacturerService;

	public ActionManufacturers() {
		super();
		manufacturerService = new ManufacturerServiceImplementation();
	}

	@Override
	public String executeRequest(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("manufacturers", manufacturerService.getAll());
		return WebConstants.PAGE_MANUFACTURERS;
	}

}
