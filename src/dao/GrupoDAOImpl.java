package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import entidades.Grupo;


public class GrupoDAOImpl implements GrupoDAO {

	private static EntityManagerFactory factory;
	static {
		factory = Persistence.createEntityManagerFactory("Control");
	}
	
	
	public void inserir(Grupo grupo) {
		
		EntityManager em = getManager();
		try{ 
			em.getTransaction().begin();
			em.merge(grupo);
			em.getTransaction().commit();
		} catch (Exception e){
			em.getTransaction().rollback();
		}
		em.close();
	}
	
	public void alterar(Grupo grupo) {

		EntityManager em = getManager();
		try{ 
			em.getTransaction().begin();
			em.merge(grupo);
			em.getTransaction().commit();
		} catch (Exception e){
			em.getTransaction().rollback();
		}
		em.close();

	}

	public void remover(Grupo grupo) {
		
		EntityManager em = getManager();
		try{ 
			em.getTransaction().begin();
			em.remove(grupo);
			em.getTransaction().commit();
		} catch (Exception e){
			em.getTransaction().rollback();
		}
		em.close();

	}

	public Grupo pesquisar(Grupo grupo) {
		
			EntityManager em = getManager();	
			Grupo grupos = new Grupo();
			
			em.getTransaction().begin();
			grupo = em.find(Grupo.class, grupo.getNomeDoGrupo());
			em.getTransaction().commit();
			em.close();
			
			return grupos;
	}
	
	
	
	@SuppressWarnings("unchecked")
	public List<Grupo> listarTodos() {
			EntityManager em = getManager();
			List<Grupo> grupos = new ArrayList<Grupo>();
			try {
				em.getTransaction().begin();
				Query consulta = em.createQuery("select contato from Contato contato");
				grupos = consulta.getResultList();
				em.getTransaction().commit();
			} catch (Exception e){
				em.getTransaction().rollback();
			}
			em.close();
		return grupos;
	}
			
	public static EntityManager getManager(){
		return factory.createEntityManager();
	}	
}
