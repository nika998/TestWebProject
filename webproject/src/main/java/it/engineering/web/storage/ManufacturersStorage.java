package it.engineering.web.storage;

import java.util.List;

import javax.persistence.EntityManager;

import it.engineering.web.domain.Proizvodjac;
import it.engineering.web.domain.User;
import it.engineering.web.persistence.MyEntityManagerFactory;

public class ManufacturersStorage {
	
	private List<Proizvodjac> manufacturers;
	private static ManufacturersStorage instance;
	
	public ManufacturersStorage() {
		manufacturers = getAll();
		
	}
	
	public static ManufacturersStorage getInstance() {
		if (instance == null) instance = new ManufacturersStorage();
		return instance;
	}
	
	public List<Proizvodjac> getAll(){
		EntityManager em = MyEntityManagerFactory.getEntityManagerFactory().createEntityManager();
		
		//JPQL
		List<Proizvodjac> manufacturers = em.createQuery("select p from Proizvodjac p", Proizvodjac.class)
				.getResultList();
		System.out.println(manufacturers.size());
		
		//manufacturers = (List<Manufacturer>) em.createNamedQuery("Manufacturer.findAll",Manufacturer.class);
		
		return manufacturers;
	}

}
