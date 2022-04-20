package it.engineering.web.dao.jpaimplementation;

import java.util.List;

import javax.persistence.EntityManager;

import it.engineering.web.dao.CityDao;
import it.engineering.web.domain.Mesto;

public class JPACityDaoImplementation implements CityDao{
	
	private EntityManager em;	

	public JPACityDaoImplementation(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public void add(Mesto p) {
		em.getTransaction().begin();
		em.merge(p);
		em.getTransaction().commit();
		
	}

	@Override
	public void update(Mesto p) {
		em.getTransaction().begin();
		em.merge(p);
		em.getTransaction().commit();
		
	}

	@Override
	public void remove(Mesto p) {
		em.getTransaction().begin();
		em.remove(p);
		em.getTransaction().commit();
		
	}

	@Override
	public List<Mesto> getAll() {
		List<Mesto> cities = em.createQuery("select p from Mesto p", Mesto.class)
				.getResultList();
		return cities;
	}

	@Override
	public Mesto findByID(int pttBroj) {
		return em.find(Mesto.class,pttBroj);
	}

}
