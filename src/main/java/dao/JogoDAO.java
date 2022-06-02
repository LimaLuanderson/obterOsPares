/*
 * c) [2,0 pts] Criar a classe JogoDAO que deve ser capaz de salvar (0,5 pts),
 *  editar (0,5 pts), excluir (0,5 pts) e listar (0,5 pts)
 *  objetos do tipo Jogo criados no item “a” utilizando o EntityManager em todos os métodos. 
 * */


package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import entidade.Jogo;
import util.JPAUtil;

public class JogoDAO {
	
	public static void salvar(Jogo j) {
		EntityManager em = JPAUtil.criarEntityManager();
		em.getTransaction().begin();
		em.persist(j);
		em.getTransaction().commit();
		em.close();
	}
	
	public static void editar(Jogo j) {
		EntityManager em = JPAUtil.criarEntityManager();
		em.getTransaction().begin();
		em.merge(j);
		em.getTransaction().commit();
		em.close();
	}
	
	public static void deletar(Jogo j) {
		EntityManager em = JPAUtil.criarEntityManager();
		em.getTransaction().begin();
		j = em.find(Jogo.class, j.getId());
		em.remove(j);
		em.getTransaction().commit();
		em.close();
	}
	
	@SuppressWarnings("unchecked")
	public static List<Jogo> listar() {
		EntityManager em = JPAUtil.criarEntityManager();
		Query q = em.createQuery("select j from Jogo j");
		List<Jogo> lista = q.getResultList();
		em.close();
		return lista;
	}
}
