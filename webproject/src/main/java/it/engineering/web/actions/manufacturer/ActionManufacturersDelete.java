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
import it.engineering.web.storage.ManufacturersStorage;

public class ActionManufacturersDelete extends AbstractAction {

	@Override
	public String executeRequest(HttpServletRequest request, HttpServletResponse response) {
		String operation = request.getParameter("operation");
		switch (operation) {
		case "Cancel": {
			request.setAttribute("manufacturers", ManufacturersStorage.getInstance().getAll());
			return WebConstants.PAGE_MANUFACTURERS;
		}
		case "Delete": {
			Proizvodjac existingMan = getProizvodjac(request.getParameter("maticniBroj"));
			if (existingMan != null) {

				remove(existingMan);

				request.setAttribute("manufacturers", ManufacturersStorage.getInstance().getAll());
				return WebConstants.PAGE_MANUFACTURERS;
			} else {
				request.setAttribute("error", "Proizvodjac sa datim pib-om ne postoji");
				return WebConstants.PAGE_MANUFACTURERS_DELETE;
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

	public void remove(Proizvodjac man) {
		EntityManager em = MyEntityManagerFactory.getEntityManagerFactory().createEntityManager();
		em.getTransaction().begin();

		em.remove(em.contains(man) ? man : em.merge(man));

		em.getTransaction().commit();
		em.close();
	}

}
