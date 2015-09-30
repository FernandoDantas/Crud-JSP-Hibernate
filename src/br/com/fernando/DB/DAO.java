package br.com.fernando.DB;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.Session;
import org.hibernate.ejb.EntityManagerImpl;

public class DAO {

	private static EntityManagerFactory emf = null; 


	public EntityManagerFactory getEntityManager(){
		
		if(emf == null){
			emf = Persistence.createEntityManagerFactory("sistema");
		}
		
		return emf;
	}
	
	public DAO() {
		
	}
	
	public Session getSession(){
	    Session session = null;
	    
	    if (getEntityManager().createEntityManager().getDelegate() instanceof EntityManagerImpl) {
	        EntityManagerImpl entityManagerImpl = (EntityManagerImpl) getEntityManager().createEntityManager().getDelegate();
	       return entityManagerImpl.getSession();
	    } else {
	    	return (Session) getEntityManager().createEntityManager().getDelegate();
	    }
	}
}