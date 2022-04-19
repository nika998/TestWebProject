package it.engineering.web.dao;

import java.util.List;

import it.engineering.web.domain.Mesto;

public interface CityDao {
	
	public void add(Mesto p);
    
    public void update(Mesto p);
    
    public void remove(Mesto p);
    
    public List<Mesto> getAll();

}
