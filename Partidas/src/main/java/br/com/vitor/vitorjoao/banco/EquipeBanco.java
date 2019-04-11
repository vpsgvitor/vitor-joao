package br.com.vitor.vitorjoao.banco;

import java.util.List;

import br.com.vitor.vitorjoao.dao.EquipeDao;
import br.com.vitor.vitorjoao.model.Equipe;

public class EquipeBanco implements EquipeDao {

	@Override
	public void salvar(Equipe dado) {
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
	public void alterar(Equipe dado) {
		try {
			Banco.conectar();
			Equipe equipe = Banco.getEntityManager().find(Equipe.class, dado.getId());
			equipe.setNome(dado.getNome());
			equipe.setPontuacao(dado.getPontuacao());
			Banco.getEntityManager().merge(equipe);
			Banco.getEntityManager().getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			Banco.getEntityManager().getTransaction().rollback();
		} finally {
			Banco.desconectar();
		}
	}

	@Override
	public void excluir(Equipe dado) {
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
	public List<Equipe> listar() {
		try {
			Banco.conectar();
			return Banco.getEntityManager().createQuery("select e from Equipe e", Equipe.class).getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			Banco.desconectar();
		}
	}

	@Override
	public Equipe findOne(Long id) {
		try {
			Banco.conectar();
			return Banco.getEntityManager().find(Equipe.class, id);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			return null;
		} finally {
			Banco.desconectar();
		}
	}
}