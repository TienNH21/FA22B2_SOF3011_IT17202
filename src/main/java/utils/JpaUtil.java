package utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {
	private static EntityManagerFactory factory;
	private static EntityManager em;
	
	private static EntityManagerFactory getFactory()
	{
		if (factory == null || factory.isOpen() == false) {
			factory = Persistence.createEntityManagerFactory("IT17202");
		}
		
		return factory;
	}
	
	public static EntityManager getEntityManager()
	{
		if (em == null || em.isOpen() == false) {
			em = getFactory().createEntityManager();
		}

		return em;
	}
}
