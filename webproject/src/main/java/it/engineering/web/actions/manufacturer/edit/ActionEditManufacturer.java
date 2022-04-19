package it.engineering.web.actions.manufacturer.edit;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.engineering.web.actions.AbstractAction;
import it.engineering.web.constants.WebConstants;
import it.engineering.web.service.CityService;
import it.engineering.web.service.ManufacturerService;
import it.engineering.web.service.implementation.CityServiceImplementation;
import it.engineering.web.service.implementation.ManufacturerServiceImplementation;




public class ActionEditManufacturer extends AbstractAction{
	
	private CityService cityService;
	private ManufacturerService manufacturerService;

	public ActionEditManufacturer() {
		super();
		cityService = new CityServiceImplementation();
		manufacturerService = new ManufacturerServiceImplementation();
	}

	@Override
	public String executeRequest(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("cities", cityService.getAll());
		request.setAttribute("manufacturers", manufacturerService.getAll());
		return WebConstants.PAGE_MANUFACTURERS_EDIT;
	}
	
	

}
