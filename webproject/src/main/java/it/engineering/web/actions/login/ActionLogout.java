package it.engineering.web.actions.login;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.engineering.web.actions.AbstractAction;
import it.engineering.web.constants.WebConstants;
import it.engineering.web.domain.User;

public class ActionLogout extends AbstractAction{

	@Override
	public String executeRequest(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession s = request.getSession(true);

		User logoutUser = (User) s.getAttribute("loginUser");
		logout(request, logoutUser);
		return WebConstants.PAGE_LOGIN;
	}

	private void logout(HttpServletRequest request, User logoutUser) {
		ServletContext sc = request.getServletContext();
		List<User> activeUsers = (List<User>) sc.getAttribute("activeUsers");
		for (User user : activeUsers) {
			if(user.getUsername().equals(logoutUser.getUsername())) {
				activeUsers.remove(user);
				break;
			}
		}
	}

}
