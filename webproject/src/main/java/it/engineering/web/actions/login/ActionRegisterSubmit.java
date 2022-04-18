package it.engineering.web.actions.login;

import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.engineering.web.actions.AbstractAction;
import it.engineering.web.constants.WebConstants;
import it.engineering.web.domain.User;
import it.engineering.web.persistence.MyEntityManagerFactory;
import it.engineering.web.storage.UserStorage;

public class ActionRegisterSubmit extends AbstractAction {

	@Override
	public String executeRequest(HttpServletRequest request, HttpServletResponse response) {
		User user;
		try {
			user = register(request);
			if (user != null) {
				save(user);
				request.setAttribute("error_message", "Uspesno ste se registrovali");
				return WebConstants.PAGE_LOGIN;
			}
			return null;
		} catch (Exception e) {
			request.setAttribute("error_message", e.getMessage());
			return WebConstants.PAGE_LOGIN;
		}

	}

	private void save(User user) {
		EntityManager em = MyEntityManagerFactory.getEntityManagerFactory().createEntityManager();
		em.getTransaction().begin();

		em.persist(user);

		em.getTransaction().commit();
		em.close();

	}

	private User register(HttpServletRequest request) throws Exception {
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setFirstname(request.getParameter("firstname"));
		user.setLastname(request.getParameter("lastname"));

		List<User> users = UserStorage.getInstance().getAll();
		for (User current : users) {
			if (current.getUsername().equals(user.getUsername())) {
				throw new Exception("Korisnik sa datim korisnickim imenom vec postoji!");
			}

		}

		return user;
	}

}
