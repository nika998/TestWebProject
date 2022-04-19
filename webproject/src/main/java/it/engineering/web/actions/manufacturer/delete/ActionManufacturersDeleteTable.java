package it.engineering.web.actions.manufacturer.delete;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.engineering.web.actions.AbstractAction;
import it.engineering.web.constants.WebConstants;

public class ActionManufacturersDeleteTable extends AbstractAction {

	@Override
	public String executeRequest(HttpServletRequest request, HttpServletResponse response) {

		String maticniBroj = request.getParameter("maticniBroj");
		request.setAttribute("maticniBroj", maticniBroj);
		return WebConstants.PAGE_MANUFACTURERS_DELETE_CONFIRM;
	}

}
