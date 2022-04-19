package it.engineering.web.actions.login;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.engineering.web.actions.AbstractAction;
import it.engineering.web.constants.WebConstants;
import it.engineering.web.domain.User;
import it.engineering.web.service.UserService;
import it.engineering.web.service.implementation.UserServiceImplementation;

public class ActionRegisterSubmit extends AbstractAction {
	
	UserService userService;
	
	public ActionRegisterSubmit() {
		super();
		userService = new UserServiceImplementation();
	}

	@Override
	public String executeRequest(HttpServletRequest request, HttpServletResponse response) {
		String operation = request.getParameter("operation");
		switch (operation) {
		case "Registruj se":
			User user;
			try {
				user = register(request);
				if (user != null) {
					userService.add(user);
					request.setAttribute("error_message", "Uspesno ste se registrovali");
					return WebConstants.PAGE_LOGIN;
				}
				return null;
			} catch (Exception e) {
				request.setAttribute("error_message", e.getMessage());
				return WebConstants.PAGE_LOGIN;
			}
		case "Nazad":
			return WebConstants.PAGE_LOGIN;
		}
		return null;

	}

	private User register(HttpServletRequest request) throws Exception {
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setFirstname(request.getParameter("firstname"));
		user.setLastname(request.getParameter("lastname"));

		List<User> users = userService.getAll();
		for (User current : users) {
			if (current.getUsername().equals(user.getUsername())) {
				throw new Exception("Korisnik sa datim korisnickim imenom vec postoji!");
			}
		}
		return user;
	}

}
