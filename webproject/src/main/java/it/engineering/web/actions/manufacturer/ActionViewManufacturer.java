package it.engineering.web.actions.manufacturer;

import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.engineering.web.actions.AbstractAction;
import it.engineering.web.constants.WebConstants;
import it.engineering.web.domain.Proizvodjac;
import it.engineering.web.storage.CityStorage;
import it.engineering.web.storage.ManufacturersStorage;

public class ActionViewManufacturer extends AbstractAction {

	@Override
	public String executeRequest(HttpServletRequest request, HttpServletResponse response) {
		Proizvodjac existingMan = getProizvodjac(request.getParameter("maticniBroj"));
		request.setAttribute("manufacturer", existingMan);
		request.setAttribute("cities", CityStorage.getInstance().getAll());
		return WebConstants.PAGE_MANUFACTURERS_EDIT_PIB;
	}

	private Proizvodjac getProizvodjac(String maticniBroj) {
		List<Proizvodjac> manufacturers = ManufacturersStorage.getInstance().getAll();

		for (Proizvodjac man : manufacturers) {
			if (man.getMaticniBroj().equals(maticniBroj))
				return man;
		}

		return null;

	}

}
