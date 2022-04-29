package it.engineering.web.dao.jpaimplementation;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import it.engineering.web.dao.ManufacturerDao;
import it.engineering.web.domain.Mesto;
import it.engineering.web.domain.Proizvodjac;

@Component(value = "manufacturerJpa")
public class JPAManufacturerDaoImplementation implements ManufacturerDao {

	@Autowired
	private EntityManager em;

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
		if (city == null)
			em.merge(p);
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
