package it.engineering.web.actions.manufacturer.delete;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.engineering.web.actions.AbstractAction;
import it.engineering.web.constants.WebConstants;
import it.engineering.web.domain.Proizvodjac;
import it.engineering.web.service.ManufacturerService;
import it.engineering.web.service.implementation.ManufacturerServiceImplementation;

@Component
public class ActionManufacturersDeleteConfirm extends AbstractAction {
	
	@Autowired
	private ManufacturerService manufacturerService;

	@Override
	public String executeRequest(HttpServletRequest request, HttpServletResponse response) {
		String operation = request.getParameter("operation");
		switch (operation) {
		case "Odustani": {
			request.setAttribute("maticniBroj", request.getParameter("maticniBroj"));
			request.setAttribute("manufacturers", manufacturerService.getAll());	
			return WebConstants.PAGE_MANUFACTURERS_DELETE;
		}
		case "Potvrdi": {
			Proizvodjac existingMan = getProizvodjac(request.getParameter("maticniBroj"));
			remove(existingMan);
			request.setAttribute("manufacturers", manufacturerService.getAll());
			request.setAttribute("alert", "deleted");
			return WebConstants.PAGE_MANUFACTURERS;

		}
		}
		return null;
	}

	private Proizvodjac getProizvodjac(String maticniBroj) {
		List<Proizvodjac> manufacturers = manufacturerService.getAll();

		for (Proizvodjac man : manufacturers) {
			if (man.getMaticniBroj().equals(maticniBroj))
				return man;
		}

		return null;

	}

	public void remove(Proizvodjac man) {
		manufacturerService.remove(man);
	}

}
