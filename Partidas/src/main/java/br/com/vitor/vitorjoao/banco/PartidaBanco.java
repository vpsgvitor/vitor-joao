package br.com.vitor.vitorjoao.banco;

import java.util.List;

import br.com.vitor.vitorjoao.dao.PartidaDao;
import br.com.vitor.vitorjoao.model.Partida;

public class PartidaBanco implements PartidaDao {

	@Override
	public void salvar(Partida dado) {
		try {
			Banco.getEntityTransaction().begin();

			Banco.getEntityManager().persist(dado);

			Banco.getEntityTransaction().commit();

		} catch (Exception e) {
			System.out.println("Erro ***");
			Banco.getEntityTransaction().rollback();
		} finally {
			Banco.getEntityManager().close();
			Banco.getEntityManagerFactory().close();
		}
	}

	@Override
	public void alterar(Partida dado) {

		try {
			Banco.getEntityTransaction().begin();

			Partida partida = Banco.getEntityManager().find(Partida.class, dado.getId());

			partida.setId(dado.getId());
			partida.setEquipe1(dado.getEquipe1());
			partida.setEquipe2(dado.getEquipe2());

			Banco.getEntityManager().merge(partida);

			Banco.getEntityTransaction().commit();

		} catch (Exception e) {
			System.out.println("Erro ***");
			Banco.getEntityTransaction().rollback();
		} finally {
			Banco.getEntityManager().close();
			Banco.getEntityManagerFactory().close();
		}

	}

	@Override
	public void excluir(Partida dado) {
		try {
			Banco.getEntityTransaction().begin();

			Banco.getEntityManager().remove(dado);

			Banco.getEntityTransaction().commit();

		} catch (Exception e) {
			System.out.println("Erro ***");
			Banco.getEntityTransaction().rollback();
		} finally {
			Banco.getEntityManager().close();
			Banco.getEntityManagerFactory().close();
		}
	}

	@Override
	public List<Partida> listar() {
		return Banco.getEntityManager().createQuery("select p from Partida p", Partida.class).getResultList();

	}

	@Override
	public Partida findOne(Long id) {
		return Banco.getEntityManager().find(Partida.class, id);
	}

}
