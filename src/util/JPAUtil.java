package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	
	private static EntityManagerFactory factory = null;
	 static {
		 if (factory == null){
			 factory = Persistence.createEntityManagerFactory("Control");
		 }
	 }
	 
	 public static EntityManager getEntityManager(){
		 return factory.createEntityManager();
	 }
	 
	 public static Object getPrimaryKey(Object contato){
			return factory.getPersistenceUnitUtil().getIdentifier(contato);
		}
}

