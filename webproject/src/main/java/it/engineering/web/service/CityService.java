package it.engineering.web.service;

import java.util.List;

import it.engineering.web.domain.Mesto;

public interface CityService {
	
     public void add(Mesto p);
     
     public void update(Mesto p);
     
     public void remove(Mesto p);
     
     public List<Mesto> getAll();
}
