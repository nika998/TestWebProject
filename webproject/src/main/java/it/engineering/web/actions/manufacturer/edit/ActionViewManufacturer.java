package it.engineering.web.actions.manufacturer.edit;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.engineering.web.actions.AbstractAction;
import it.engineering.web.constants.WebConstants;
import it.engineering.web.domain.Proizvodjac;
import it.engineering.web.service.CityService;
import it.engineering.web.service.ManufacturerService;
import it.engineering.web.service.implementation.CityServiceImplementation;
import it.engineering.web.service.implementation.ManufacturerServiceImplementation;

@Component
public class ActionViewManufacturer extends AbstractAction {
	
	@Autowired
	private CityService cityService;
	@Autowired
	private ManufacturerService manufacturerService;

	public ActionViewManufacturer() {
		super();
		cityService = new CityServiceImplementation();
		manufacturerService = new ManufacturerServiceImplementation();
	}

	@Override
	public String executeRequest(HttpServletRequest request, HttpServletResponse response) {
		Proizvodjac existingMan = getProizvodjac(request.getParameter("maticniBroj"));
		request.setAttribute("manufacturer", existingMan);
		request.setAttribute("cities", cityService.getAll());
		return WebConstants.PAGE_MANUFACTURERS_EDIT_PIB;
	}

	private Proizvodjac getProizvodjac(String maticniBroj) {
		List<Proizvodjac> manufacturers = manufacturerService.getAll();

		for (Proizvodjac man : manufacturers) {
			if (man.getMaticniBroj().equals(maticniBroj))
				return man;
		}

		return null;

	}

}
