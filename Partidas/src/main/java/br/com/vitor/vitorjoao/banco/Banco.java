package br.com.vitor.vitorjoao.banco;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Banco {

	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenciaPartidas");
	private static EntityManager em;
	private static EntityTransaction et;

	static {

		em = emf.createEntityManager();
		et = em.getTransaction();

		et.begin();

	}

	public static EntityManager getEntityManager() {
		return em;
	}

	public static EntityTransaction getEntityTransaction() {
		return et;
	}

	public static EntityManagerFactory getEntityManagerFactory() {
		return emf;
	}
}
