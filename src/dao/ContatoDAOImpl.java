package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import entidades.Contato;


public class ContatoDAOImpl implements ContatoDAO {
	
	private static EntityManagerFactory factory;
	static {
		factory = Persistence.createEntityManagerFactory("Control");
	}
	
	
	public void inserir(Contato contato) {
			EntityManager em = getManager();
		try{ 
			em.getTransaction().begin();
			em.merge(contato);
			em.getTransaction().commit();
		} catch (Exception e){
			em.getTransaction().rollback();
		}
		em.close();
		
	}
	
	public void alterar(Contato contato) {
		EntityManager em = getManager();
		try{ 
			em.getTransaction().begin();
			em.merge(contato);
			em.getTransaction().commit();
		} catch (Exception e){
			em.getTransaction().rollback();
		}
		em.close();
		
	}

	public void remover(Contato contato) {
		
		EntityManager em = getManager();
		try{ 
			em.getTransaction().begin();
			em.remove(em.getReference(Contato.class, contato.getId()));
			em.getTransaction().commit();
		} catch (Exception e){
			em.getTransaction().rollback();
		}
		em.close();
				
	}

	public Contato pesquisar(Contato contato) {
		
		    EntityManager em = getManager();	
		    Contato contatos = new Contato();
			
			em.getTransaction().begin();
			contatos = em.find(Contato.class, contato.getNome());
			em.getTransaction().commit();
			em.close();
			
		return contatos;
	}
	

	
	
	@SuppressWarnings("unchecked")
	public List<Contato> listarTodos() {
		EntityManager em = getManager();
			List<Contato> contatos = new ArrayList<Contato>();
		try {
			em.getTransaction().begin();
			Query consulta = em.createQuery("select contato from Contato contato");
			contatos = consulta.getResultList();
			em.getTransaction().commit();
		} catch (Exception e){
			em.getTransaction().rollback();
		}
		em.close();
		return contatos;
	}
	
	
	
	public static EntityManager getManager(){
		return factory.createEntityManager();
	}		
}
