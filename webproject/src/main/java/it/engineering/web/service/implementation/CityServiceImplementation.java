package it.engineering.web.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import it.engineering.web.dao.CityDao;
import it.engineering.web.dao.jdbctemplateimpl.CityJDBCTemplateImpl;
import it.engineering.web.domain.Mesto;
import it.engineering.web.service.CityService;

@Service
public class CityServiceImplementation implements CityService{

	@Autowired@Qualifier(value = "cityJdbcTemplate")
	private CityDao cityDao;

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
