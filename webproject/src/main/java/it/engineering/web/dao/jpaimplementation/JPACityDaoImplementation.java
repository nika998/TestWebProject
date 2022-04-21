package it.engineering.web.dao.jpaimplementation;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Component;

import it.engineering.web.dao.CityDao;
import it.engineering.web.domain.Mesto;

@Component(value = "cityJpa")
public class JPACityDaoImplementation implements CityDao{
	
	private EntityManager em;	
	
	public JPACityDaoImplementation() {
		super();
		em = EntityManagerFactory.getEntityManager();
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
