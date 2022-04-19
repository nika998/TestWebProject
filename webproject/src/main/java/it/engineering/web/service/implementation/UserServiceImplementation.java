package it.engineering.web.service.implementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import it.engineering.web.dao.UserDao;
import it.engineering.web.dao.implementation.JPAUserDaoImplementation;
import it.engineering.web.domain.User;
import it.engineering.web.service.UserService;

public class UserServiceImplementation implements UserService {

	private EntityManager em;
	private UserDao userDao;

	public UserServiceImplementation() {
		em = Persistence.createEntityManagerFactory("webproject").createEntityManager();
		userDao = new JPAUserDaoImplementation(em);

	}

	@Override
	public void add(User p) {
		userDao.add(p);

	}

	@Override
	public void update(User p) {
		userDao.update(p);

	}

	@Override
	public void remove(User p) {
		userDao.remove(p);

	}

	@Override
	public List<User> getAll() {
		
		return userDao.getAll();
	}

}
