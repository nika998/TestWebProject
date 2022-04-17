package it.engineering.web.storage;

import java.util.List;

import javax.persistence.EntityManager;

import it.engineering.web.domain.Mesto;
import it.engineering.web.domain.Proizvodjac;
import it.engineering.web.domain.User;
import it.engineering.web.persistence.MyEntityManagerFactory;

public class CityStorage {
	
	private List<Mesto> mesta;
	private static CityStorage instance;
	
	public CityStorage() {
		mesta = getAll();
		
	}
	
	public static CityStorage getInstance() {
		if (instance == null) instance = new CityStorage();
		return instance;
	}
	
	public List<Mesto> getAll(){
		EntityManager em = MyEntityManagerFactory.getEntityManagerFactory().createEntityManager();
		
		//JPQL
		List<Mesto> mesta = em.createQuery("select m from Mesto m", Mesto.class)
				.getResultList();
		
		
		//manufacturers = (List<Manufacturer>) em.createNamedQuery("Manufacturer.findAll",Manufacturer.class);
		
		return mesta;
	}

	public void add(Mesto mesto) {
		mesta.add(mesto);
		
	}

}
