package it.engineering.web.service.implementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import it.engineering.web.dao.ManufacturerDao;
import it.engineering.web.dao.implementation.JPAManufacturerDaoImplementation;
import it.engineering.web.domain.Proizvodjac;
import it.engineering.web.service.ManufacturerService;

public class ManufacturerServiceImplementation implements ManufacturerService{
	
	private EntityManager em;
	private ManufacturerDao manufacturerDao;

	public ManufacturerServiceImplementation() {
		em = Persistence.createEntityManagerFactory("webproject").createEntityManager();
		manufacturerDao = new JPAManufacturerDaoImplementation(em);

	}

	@Override
	public void add(Proizvodjac p) {
		manufacturerDao.add(p);
		
	}

	@Override
	public void update(Proizvodjac p) {
		manufacturerDao.update(p);
		
	}

	@Override
	public void remove(Proizvodjac p) {
		manufacturerDao.remove(p);
		
	}

	@Override
	public List<Proizvodjac> getAll() {
		return manufacturerDao.getAll();
	}

}
