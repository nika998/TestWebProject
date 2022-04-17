package it.engineering.web.actions.manufacturer;

import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.engineering.web.actions.AbstractAction;
import it.engineering.web.constants.WebConstants;
import it.engineering.web.domain.Mesto;
import it.engineering.web.domain.Proizvodjac;
import it.engineering.web.persistence.MyEntityManagerFactory;
import it.engineering.web.storage.CityStorage;
import it.engineering.web.storage.ManufacturersStorage;

public class ActionManufacturersEdit extends AbstractAction {

	@Override
	public String executeRequest(HttpServletRequest request, HttpServletResponse response) {
		String operation = request.getParameter("operation");
		switch (operation) {
		case "Cancel": {
			request.setAttribute("manufacturers", ManufacturersStorage.getInstance().getAll());
			return WebConstants.PAGE_MANUFACTURERS;
		}
		case "Save changes": {
			Proizvodjac existingMan = getProizvodjac(request.getParameter("maticniBroj"));
			if (existingMan != null) {
				int pib;
				try {
					pib = Integer.parseInt(request.getParameter("pib"));
					if (request.getParameter("pib").length() != 9)
						throw new Exception();
				} catch (Exception e) {
					request.setAttribute("manufacturers", ManufacturersStorage.getInstance().getAll());
					request.setAttribute("error", "Pib nije unet u ispravnom formatu");
					request.setAttribute("cities", CityStorage.getInstance().getAll());
					return WebConstants.PAGE_MANUFACTURERS_EDIT;

				}
				existingMan.setPib(request.getParameter("pib"));
				existingMan.setAdresa(request.getParameter("adresa"));
				Mesto mesto = getMesto(Integer.parseInt(request.getParameter("postanskiBroj")));
				existingMan.setMesto(mesto);

				update(existingMan);
				request.setAttribute("manufacturers", ManufacturersStorage.getInstance().getAll());
				return WebConstants.PAGE_MANUFACTURERS;
			} else {
				request.setAttribute("error", "Proizvodjac sa datim Maticnim brojem ne postoji");
				return WebConstants.PAGE_MANUFACTURERS_EDIT;
			}

		}
		}
		return null;
	}

	private Mesto getMesto(int parameter) {
		List<Mesto> cities = CityStorage.getInstance().getAll();

		for (Mesto mesto : cities) {
			if (mesto.getPttBroj() == parameter)
				return mesto;
		}

		return null;
	}

	private Proizvodjac getProizvodjac(String maticniBroj) {
		List<Proizvodjac> manufacturers = ManufacturersStorage.getInstance().getAll();

		for (Proizvodjac man : manufacturers) {
			if (man.getMaticniBroj().equals(maticniBroj))
				return man;
		}

		return null;

	}

	public void update(Proizvodjac man) {
		EntityManager em = MyEntityManagerFactory.getEntityManagerFactory().createEntityManager();
		em.getTransaction().begin();

		em.merge(man);

		em.getTransaction().commit();
		em.close();
	}

}
