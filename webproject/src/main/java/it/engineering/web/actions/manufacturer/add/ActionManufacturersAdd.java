package it.engineering.web.actions.manufacturer.add;

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

public class ActionManufacturersAdd extends AbstractAction {
	
	private CityService cityService;
	private ManufacturerService manufacturerService;

	public ActionManufacturersAdd() {
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
		case "Dodaj": {
			@SuppressWarnings("unused")
			int maticniBroj;
			try {
				maticniBroj = Integer.parseInt(request.getParameter("maticniBroj"));
				if (request.getParameter("maticniBroj").length() != 8)
					throw new Exception();
			} catch (Exception e) {
				request.setAttribute("manufacturers", manufacturerService.getAll());
				request.setAttribute("error", "Maticni broj nije unet u ispravnom formatu");
				request.setAttribute("cities", cityService.getAll());
				return WebConstants.PAGE_MANUFACTURERS_ADD;
			}
			Proizvodjac existingMan = getProizvodjac(request.getParameter("maticniBroj"));
			if (existingMan == null) {
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
					return WebConstants.PAGE_MANUFACTURERS_ADD;

				}
				Proizvodjac man = new Proizvodjac(request.getParameter("maticniBroj"), request.getParameter("pib"),
						request.getParameter("adresa"),
						getMesto(Integer.parseInt(request.getParameter("postanskiBroj"))));
				request.setAttribute("manufacturer", man);
				saveWithAdditionSpecification(man);
				request.setAttribute("manufacturers", manufacturerService.getAll());
				return WebConstants.PAGE_MANUFACTURERS;
			} else {
				request.setAttribute("manufacturers", manufacturerService.getAll());
				request.setAttribute("error", "Grad vec postoji u listi");
				request.setAttribute("cities", cityService.getAll());
				return WebConstants.PAGE_MANUFACTURERS_ADD;
			}

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

	public void saveWithAdditionSpecification(Proizvodjac man) {
		manufacturerService.add(man);
	}

	private Mesto getMesto(int parameter) {
		List<Mesto> cities = cityService.getAll();

		for (Mesto mesto : cities) {
			if (mesto.getPttBroj() == parameter)
				return mesto;
		}

		return null;
	}

}
