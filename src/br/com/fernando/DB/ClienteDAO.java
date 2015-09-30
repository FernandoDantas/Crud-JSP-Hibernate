package br.com.fernando.DB;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;

public class ClienteDAO extends DAO {

	public void salvar(Cliente cliente){
		EntityManager em = getEntityManager().createEntityManager();
		
		try{
			em.getTransaction().begin();
			em.persist(cliente);
			em.getTransaction().commit();
		}catch (Exception e) {
			em.getTransaction().rollback();
		}
	}
	
	public Cliente getById(int idCliente){
		EntityManager em = getEntityManager().createEntityManager();
		return em.find(Cliente.class, idCliente);
	}
	
	public void update(Cliente cliente){
		EntityManager em = getEntityManager().createEntityManager();
		
		try{
			em.getTransaction().begin();
			Cliente c = em.find(Cliente.class, cliente.getId());
			c.setNome(cliente.getNome());
			c.setSobrenome(cliente.getSobrenome());
			c.setCat(cliente.getCat());
			em.getTransaction().commit();
		} catch(Exception e){
			em.getTransaction().rollback();
		}
	}
	
	public void delete(Cliente cliente){
		EntityManager em = getEntityManager().createEntityManager();
		
		try{
			em.getTransaction().begin();
			Cliente c = em.find(Cliente.class, cliente.getId());
			em.remove(c);
			em.getTransaction().commit();
		} catch(Exception e){
			em.getTransaction().rollback();
		}
	}
	
	public List<Cliente> exibir_by_name(String nome){
		EntityManager em = getEntityManager().createEntityManager();
		
		Criteria criteria = getSession().createCriteria(Cliente.class);
		//criteria.add(Restrictions.eq("nome", "Rafael"));
		//criteria.add(Restrictions.like("nome", "%R%"));
		//criteria.add(Restrictions.gt("ordem", 0));
		//gt() : maior que
		//ge() : maior ou igual que
		//lt() : menor que
		//le() : menor ou igual que
		//Criterion cr1 = Restrictions.like("nome", "%R%");
		//Criterion cr2 =  Restrictions.like("nome", "%T%");
		
		//LogicalExpression exp = Restrictions.or(cr1, cr2);
		
		//criteria.add(exp);
		
		criteria.add(Restrictions.like("nome", "%"+ nome +"%"));
		
		return criteria.list();
	}

	public List<Cliente> exibir(){
		EntityManager em = getEntityManager().createEntityManager();
		
		try{
			Query q = em.createQuery("select object(c) from Cliente as c");
			return q.getResultList();
		} finally{
			em.close();
		}
	}
}