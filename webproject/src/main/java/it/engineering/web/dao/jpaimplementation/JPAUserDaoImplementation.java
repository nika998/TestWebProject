package it.engineering.web.dao.jpaimplementation;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import it.engineering.web.dao.UserDao;
import it.engineering.web.domain.User;

@Component(value = "userJpa")
class JPAUserDaoImplementation implements UserDao {
    
	@Autowired
	private EntityManager em;

	@Override
	public void add(User p) {
		em.getTransaction().begin();
		em.merge(p);
		em.getTransaction().commit();
	}

	@Override
	public void update(User p) {
		em.getTransaction().begin();
		em.merge(p);
		em.getTransaction().commit();

	}

	@Override
	public void remove(User p) {
		em.getTransaction().begin();
		em.remove(p);
		em.getTransaction().commit();

	}

	@Override
	public List<User> getAll() {
		List<User> users = em.createQuery("select u from User u", User.class).getResultList();
		return users;

	}

}
