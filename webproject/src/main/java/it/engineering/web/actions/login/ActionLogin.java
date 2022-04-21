package it.engineering.web.actions.login;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.engineering.web.actions.AbstractAction;
import it.engineering.web.constants.WebConstants;
import it.engineering.web.domain.User;
import it.engineering.web.service.UserService;
import it.engineering.web.service.implementation.UserServiceImplementation;

@Component
public class ActionLogin extends AbstractAction {
	
	@Autowired
	private UserService userService;

	@Override
	public String executeRequest(HttpServletRequest request, HttpServletResponse response) {
		User user;
		try {
			user = login(request);
			if (user != null) {
				
				ServletContext sc = request.getServletContext();
				@SuppressWarnings("unchecked")
				List<User> activeUsers =  (List<User>) sc.getAttribute("activeUsers");
				activeUsers.add(user);
				
				HttpSession session = request.getSession(true);
	            User loginUser = user.clone();
				
				session.setAttribute("loginUser", loginUser);
				return WebConstants.PAGE_HOME;
			} else {
				
				request.setAttribute("error_message", "Korisnik ne postoji!");
				return WebConstants.PAGE_LOGIN;
			}
		} catch (Exception e) {
			request.setAttribute("error_message", e.getMessage());
			return WebConstants.PAGE_LOGIN;
		}
	
		
	}

	private User login(HttpServletRequest request) throws Exception {
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		
		 ServletContext sc = request.getServletContext();
	    
		List<User> users = userService.getAll();
		@SuppressWarnings("unchecked")
		List<User> activeUsers =  (List<User>) sc.getAttribute("activeUsers");
		for (User current : users) {
			if (current.equals(user)) {
				for(User currentUser : activeUsers) {
					if(currentUser.equals(user)) throw new Exception("Vec ste ulogovani!");
				}
				return current;
			}
				
		}

		return null;
	}

}
