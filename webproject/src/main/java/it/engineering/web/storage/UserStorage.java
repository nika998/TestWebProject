package it.engineering.web.storage;

import java.util.List;

import javax.persistence.EntityManager;

import it.engineering.web.domain.User;
import it.engineering.web.persistence.MyEntityManagerFactory;



public class UserStorage {
	private List<User> users;
	private static UserStorage instance;
	
	public UserStorage() {
		users = getAll();
		
	}
	
	public static UserStorage getInstance() {
		if (instance == null) instance = new UserStorage();
		return instance;
	}
	
	public List<User> getAll(){
		EntityManager em = MyEntityManagerFactory.getEntityManagerFactory().createEntityManager();
		
		//JPQL
		List<User> users = em.createQuery("select u from User u", User.class)
				.getResultList();
		
		//manufacturers = (List<Manufacturer>) em.createNamedQuery("Manufacturer.findAll",Manufacturer.class);
		
		return users;
	}
	
	
}
