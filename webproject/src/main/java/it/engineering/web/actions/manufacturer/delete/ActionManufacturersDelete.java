package it.engineering.web.actions.manufacturer.delete;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.engineering.web.actions.AbstractAction;
import it.engineering.web.constants.WebConstants;
import it.engineering.web.service.ManufacturerService;
import it.engineering.web.service.implementation.ManufacturerServiceImplementation;

public class ActionManufacturersDelete extends AbstractAction {
	
	private ManufacturerService manufacturerService;

	public ActionManufacturersDelete() {
		super();
		manufacturerService = new ManufacturerServiceImplementation();
	}

	@Override
	public String executeRequest(HttpServletRequest request, HttpServletResponse response) {
		String operation = request.getParameter("operation");
		switch (operation) {
		case "Vrati": {
			request.setAttribute("manufacturers", manufacturerService.getAll());
			return WebConstants.PAGE_MANUFACTURERS;
		}
		case "Obrisi": {
			String maticniBroj = request.getParameter("maticniBroj");
			request.setAttribute("maticniBroj", maticniBroj);
			return WebConstants.PAGE_MANUFACTURERS_DELETE_CONFIRM;

		}
		}
		return null;

	}

}
