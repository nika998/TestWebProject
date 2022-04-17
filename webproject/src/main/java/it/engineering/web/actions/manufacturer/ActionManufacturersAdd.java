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

public class ActionManufacturersAdd extends AbstractAction {

	@Override
	public String executeRequest(HttpServletRequest request, HttpServletResponse response) {
		String operation = request.getParameter("operation");
		switch (operation) {
		case "Cancel": {
			request.setAttribute("manufacturers", ManufacturersStorage.getInstance().getAll());
			return WebConstants.PAGE_MANUFACTURERS;
		}
		case "Add": {
			int maticniBroj;
			try {
				maticniBroj = Integer.parseInt(request.getParameter("maticniBroj"));
				if (request.getParameter("maticniBroj").length() != 8)
					throw new Exception();
			} catch (Exception e) {
				request.setAttribute("manufacturers", ManufacturersStorage.getInstance().getAll());
				request.setAttribute("error", "Maticni broj nije unet u ispravnom formatu");
				request.setAttribute("cities", CityStorage.getInstance().getAll());
				return WebConstants.PAGE_MANUFACTURERS_ADD;
			}
			Proizvodjac existingMan = getProizvodjac(request.getParameter("maticniBroj"));
			if (existingMan == null) {
				int pib;
				try {
					pib = Integer.parseInt(request.getParameter("pib"));
					if (request.getParameter("pib").length() != 9)
						throw new Exception();
				} catch (Exception e) {
					request.setAttribute("manufacturers", ManufacturersStorage.getInstance().getAll());
					request.setAttribute("error", "Pib nije unet u ispravnom formatu");
					request.setAttribute("cities", CityStorage.getInstance().getAll());
					return WebConstants.PAGE_MANUFACTURERS_ADD;

				}
				Proizvodjac man = new Proizvodjac(request.getParameter("maticniBroj"), request.getParameter("pib"),
						request.getParameter("adresa"),
						getMesto(Integer.parseInt(request.getParameter("postanskiBroj"))));
				request.setAttribute("manufacturer", man);
				saveWithAdditionSpecification(man);
				request.setAttribute("manufacturers", ManufacturersStorage.getInstance().getAll());
				return WebConstants.PAGE_MANUFACTURERS;
			} else {
				request.setAttribute("manufacturers", ManufacturersStorage.getInstance().getAll());
				request.setAttribute("error", "Grad vec postoji u listi");
				request.setAttribute("cities", CityStorage.getInstance().getAll());
				return WebConstants.PAGE_MANUFACTURERS_ADD;
			}

		}
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

	public void saveWithAdditionSpecification(Proizvodjac man) {
		EntityManager em = MyEntityManagerFactory.getEntityManagerFactory().createEntityManager();
		em.getTransaction().begin();
		Mesto existingCity = em.find(Mesto.class, man.getMesto().getPttBroj());
		if (existingCity == null) {
			em.persist(man);
		} else {
			// em.merge(man);
			man.setMesto(existingCity);
			em.persist(man);
		}
		em.getTransaction().commit();
		em.close();
	}

	private Mesto getMesto(int parameter) {
		List<Mesto> cities = CityStorage.getInstance().getAll();

		for (Mesto mesto : cities) {
			if (mesto.getPttBroj() == parameter)
				return mesto;
		}

		return null;
	}

}
