package it.engineering.web.actions.manufacturer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.engineering.web.actions.AbstractAction;
import it.engineering.web.constants.WebConstants;
import it.engineering.web.service.ManufacturerService;
import it.engineering.web.service.implementation.ManufacturerServiceImplementation;

@Component
public class ActionManufacturers extends AbstractAction{
	
	@Autowired
	private ManufacturerService manufacturerService;


	@Override
	public String executeRequest(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("manufacturers", manufacturerService.getAll());
		return WebConstants.PAGE_MANUFACTURERS;
	}

}
