package it.engineering.web.service;

import java.util.List;

import it.engineering.web.domain.User;

public interface UserService {
	
     public void add(User p);
     
     public void update(User p);
     
     public void remove(User p);
     
     public List<User> getAll();
}
