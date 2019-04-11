package br.com.vitor.vitorjoao.banco;

import java.util.List;

import br.com.vitor.vitorjoao.dao.PartidaDao;
import br.com.vitor.vitorjoao.model.Partida;

public class PartidaBanco implements PartidaDao {

	@Override
	public void salvar(Partida dado) {
		try {
			Banco.conectar();
			Banco.getEntityManager().persist(dado);
			Banco.getEntityManager().getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			Banco.getEntityManager().getTransaction().rollback();
		} finally {
			Banco.desconectar();
		}
	}

	@Override
	public void alterar(Partida dado) {
		try {
			Banco.conectar();
			Partida partida = Banco.getEntityManager().find(Partida.class, dado.getId());
			partida.setGolsEquipe1(dado.getGolsEquipe1());
			partida.setGolsEquipe2(dado.getGolsEquipe2());
			partida.setEquipe1(dado.getEquipe1());
			partida.setEquipe2(dado.getEquipe2());
			Banco.getEntityManager().merge(partida);
			Banco.getEntityManager().getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			Banco.getEntityManager().getTransaction().rollback();
		} finally {
			Banco.desconectar();
		}
	}

	@Override
	public void excluir(Partida dado) {
		try {
			Banco.conectar();
			Banco.getEntityManager().remove(dado);
			Banco.getEntityManager().getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			Banco.getEntityManager().getTransaction().rollback();
		} finally {
			Banco.desconectar();
		}
	}

	@Override
	public List<Partida> listar() {
		try {
			Banco.conectar();
			return Banco.getEntityManager().createQuery("select p from Partida p", Partida.class).getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			Banco.desconectar();
		}
	}

	@Override
	public Partida findOne(Long id) {
		try {
			Banco.conectar();
			return Banco.getEntityManager().find(Partida.class, id);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			Banco.desconectar();
		}
	}
}