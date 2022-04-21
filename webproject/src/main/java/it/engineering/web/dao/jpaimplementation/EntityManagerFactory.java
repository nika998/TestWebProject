package it.engineering.web.dao.jpaimplementation;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class EntityManagerFactory {
	
	public static EntityManager getEntityManager() {
		return Persistence.createEntityManagerFactory("webproject").createEntityManager();
	}

}
