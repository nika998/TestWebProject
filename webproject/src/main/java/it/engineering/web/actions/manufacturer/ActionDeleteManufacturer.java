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




public class ActionDeleteManufacturer extends AbstractAction{

	@Override
	public String executeRequest(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("manufacturers", ManufacturersStorage.getInstance().getAll());
		return WebConstants.PAGE_MANUFACTURERS_DELETE;
	}
	
	

}
