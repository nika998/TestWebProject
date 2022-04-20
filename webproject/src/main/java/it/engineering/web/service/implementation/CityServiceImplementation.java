package it.engineering.web.service.implementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import it.engineering.web.dao.CityDao;
import it.engineering.web.dao.jdbctemplateimpl.CityJDBCTemplateImpl;
import it.engineering.web.domain.Mesto;
import it.engineering.web.service.CityService;

public class CityServiceImplementation implements CityService{
	
	@SuppressWarnings("unused")
	private EntityManager em;
	private CityDao cityDao;

	
	public CityServiceImplementation() {
		em = Persistence.createEntityManagerFactory("webproject")
				.createEntityManager();
		cityDao = new CityJDBCTemplateImpl();
	}

	@Override
	public void add(Mesto p) {
		cityDao.add(p);
		
	}

	@Override
	public void update(Mesto p) {
		cityDao.update(p);
		
	}

	@Override
	public void remove(Mesto p) {
		cityDao.remove(p);
		
	}

	@Override
	public List<Mesto> getAll() {
		return cityDao.getAll();
	}

}
