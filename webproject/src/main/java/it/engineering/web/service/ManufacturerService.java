package it.engineering.web.service;

import java.util.List;

import it.engineering.web.domain.Proizvodjac;

public interface ManufacturerService {
	
     public void add(Proizvodjac p);
     
     public void update(Proizvodjac p);
     
     public void remove(Proizvodjac p);
     
     public List<Proizvodjac> getAll();
}
