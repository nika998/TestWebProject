package it.engineering.web.dao.implementation;

import java.util.List;

import javax.persistence.EntityManager;

import it.engineering.web.dao.UserDao;
import it.engineering.web.domain.User;

public class JPAUserDaoImplementation implements UserDao{
	
	private EntityManager em;	

	public JPAUserDaoImplementation(EntityManager em) {
		super();
		this.em = em;
	}

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
		List<User> users = em.createQuery("select u from User u", User.class)
				.getResultList();
		return users;
		
	}

}
