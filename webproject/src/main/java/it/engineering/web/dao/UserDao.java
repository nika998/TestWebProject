package it.engineering.web.dao;

import java.util.List;

import it.engineering.web.domain.User;

public interface UserDao {
	
     public void add(User p);
     
     public void update(User p);
     
     public void remove(User p);
     
     public List<User> getAll();
}
