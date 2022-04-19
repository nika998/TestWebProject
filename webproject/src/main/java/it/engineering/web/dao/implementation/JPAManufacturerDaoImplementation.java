package it.engineering.web.dao.implementation;

import java.util.List;

import javax.persistence.EntityManager;

import it.engineering.web.dao.ManufacturerDao;
import it.engineering.web.domain.Mesto;
import it.engineering.web.domain.Proizvodjac;

public class JPAManufacturerDaoImplementation implements ManufacturerDao{
	
	private EntityManager em;	

	public JPAManufacturerDaoImplementation(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public void add(Proizvodjac p) {
		em.getTransaction().begin();
		em.merge(p);
		em.getTransaction().commit();
		
	}

	@Override
	public void update(Proizvodjac p) {
		
		em.getTransaction().begin();
		Mesto city = em.find(Mesto.class, p.getMesto().getPttBroj());
		if(city == null) em.merge(p);
		else {
			p.setMesto(city);
			em.merge(city);
		}
		em.getTransaction().commit();
		
	}

	@Override
	public void remove(Proizvodjac p) {
		em.getTransaction().begin();
		em.remove(p);
		em.getTransaction().commit();
		
	}

	@Override
	public List<Proizvodjac> getAll() {
		List<Proizvodjac> manufacturers = em.createQuery("select p from Proizvodjac p", Proizvodjac.class)
				.getResultList();
		return manufacturers;
	}

}
