package it.engineering.web.actions.manufacturer.edit;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.engineering.web.actions.AbstractAction;
import it.engineering.web.constants.WebConstants;
import it.engineering.web.domain.Mesto;
import it.engineering.web.domain.Proizvodjac;
import it.engineering.web.service.CityService;
import it.engineering.web.service.ManufacturerService;
import it.engineering.web.service.implementation.CityServiceImplementation;
import it.engineering.web.service.implementation.ManufacturerServiceImplementation;

public class ActionManufacturersEdit extends AbstractAction {
	
	private CityService cityService;
	private ManufacturerService manufacturerService;

	public ActionManufacturersEdit() {
		super();
		cityService = new CityServiceImplementation();
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
		case "Azuriraj": {
			Proizvodjac existingMan = getProizvodjac(request.getParameter("maticniBroj"));

			@SuppressWarnings("unused")
			int pib;
			try {
				pib = Integer.parseInt(request.getParameter("pib"));
				if (request.getParameter("pib").length() != 9)
					throw new Exception();
			} catch (Exception e) {
				request.setAttribute("manufacturers", manufacturerService.getAll());
				request.setAttribute("error", "Pib nije unet u ispravnom formatu");
				request.setAttribute("cities", cityService.getAll());
				return WebConstants.PAGE_MANUFACTURERS_EDIT;

			}
			existingMan.setPib(request.getParameter("pib"));
			existingMan.setAdresa(request.getParameter("adresa"));
			Mesto mesto = getMesto(Integer.parseInt(request.getParameter("postanskiBroj")));
			existingMan.setMesto(mesto);
			request.setAttribute("manufacturer", existingMan);
			request.setAttribute("cities", cityService.getAll());
			return WebConstants.PAGE_MANUFACTURERS_EDIT_CONFIRM;

		}
		}
		return null;
	}

	private Mesto getMesto(int parameter) {
		List<Mesto> cities = cityService.getAll();

		for (Mesto mesto : cities) {
			if (mesto.getPttBroj() == parameter)
				return mesto;
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

}
