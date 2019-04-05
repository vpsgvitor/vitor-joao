package br.com.vitor.vitorjoao.banco;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Banco {

	private static EntityManagerFactory emf;
	private static EntityManager em;

	public static EntityManager getEntityManager() {
		return em;
	}

	public static void conectar() {
		emf = Persistence.createEntityManagerFactory("PersistenciaPartidas");
		em = emf.createEntityManager();
		em.getTransaction().begin();
	}

	public static void desconectar() {
		em.close();
		emf.close();
	}
}
