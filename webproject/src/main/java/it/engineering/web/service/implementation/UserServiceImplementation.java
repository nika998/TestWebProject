package it.engineering.web.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import it.engineering.web.dao.UserDao;
import it.engineering.web.dao.jdbctemplateimpl.UserJDBCTemplateImpl;
import it.engineering.web.domain.User;
import it.engineering.web.service.UserService;

@Service
public class UserServiceImplementation implements UserService {
    
	@Autowired@Qualifier(value = "userJdbcTemplate")
	private UserDao userDao;

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
