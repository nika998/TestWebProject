package it.engineering.web.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import it.engineering.web.dao.ManufacturerDao;
import it.engineering.web.dao.jdbctemplateimpl.ManufacturerJDBCTemplateImpl;
import it.engineering.web.domain.Proizvodjac;
import it.engineering.web.service.ManufacturerService;

@Service
public class ManufacturerServiceImplementation implements ManufacturerService{
	
	@Autowired@Qualifier(value = "manufacturerJdbcTemplate")
	private ManufacturerDao manufacturerDao;

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
