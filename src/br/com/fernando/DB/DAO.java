package br.com.fernando.DB;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.Session;
import org.hibernate.ejb.EntityManagerImpl;

public class DAO {

	private EntityManagerFactory emf; 


	public EntityManager getEntityManager(){
		return emf.createEntityManager();
	}
	
	public DAO() {
		emf = Persistence.createEntityManagerFactory("sistema");
	}
	
	public Session getSession(){
	    Session session = null;
	    
	    if (getEntityManager().getDelegate() instanceof EntityManagerImpl) {
	        EntityManagerImpl entityManagerImpl = (EntityManagerImpl) getEntityManager().getDelegate();
	       return entityManagerImpl.getSession();
	    } else {
	    	return (Session) getEntityManager().getDelegate();
	    }
	}
}