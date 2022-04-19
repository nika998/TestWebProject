package it.engineering.web.actions.manufacturer.add;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.engineering.web.actions.AbstractAction;
import it.engineering.web.constants.WebConstants;
import it.engineering.web.service.CityService;
import it.engineering.web.service.implementation.CityServiceImplementation;



public class ActionAddManufacturer extends AbstractAction{
	
CityService cityService;
	
	public ActionAddManufacturer() {
		super();
		cityService = new CityServiceImplementation();
	}

	@Override
	public String executeRequest(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("cities", cityService.getAll());
		return WebConstants.PAGE_MANUFACTURERS_ADD;
	}
	
	

}
