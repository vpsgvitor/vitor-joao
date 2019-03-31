package br.com.vitor.vitorjoao.banco;

import java.util.List;

import br.com.vitor.vitorjoao.dao.EquipeDao;
import br.com.vitor.vitorjoao.model.Equipe;

public class EquipeBanco implements EquipeDao {

	@Override
	public void salvar(Equipe dado) {

		try {
			Banco.getEntityManager().persist(dado);

			Banco.getEntityTransaction().commit();

		} catch (Exception e) {
			System.out.println("Erro ***");
			e.printStackTrace();
			Banco.getEntityTransaction().rollback();
		}
	}

	@Override
	public void alterar(Equipe dado) {

		try {

			Equipe equipe = Banco.getEntityManager().find(Equipe.class, dado.getId());

			equipe.setId(dado.getId());
			equipe.setNome(dado.getNome());
			equipe.setPontuacao(dado.getPontuacao());
			equipe.setGolsNaPartida(dado.getGolsNaPartida());

			Banco.getEntityManager().merge(equipe);

			Banco.getEntityTransaction().commit();

		} catch (Exception e) {
			System.out.println("Erro ***");
			Banco.getEntityTransaction().rollback();
		}

	}

	@Override
	public void excluir(Equipe dado) {
		try {

			Banco.getEntityManager().remove(dado);

			Banco.getEntityTransaction().commit();

		} catch (Exception e) {
			System.out.println("Erro ***");
			Banco.getEntityTransaction().rollback();
		}
	}

	@Override
	public List<Equipe> listar() {
		return Banco.getEntityManager().createQuery("select e from Equipe e", Equipe.class).getResultList();
	}

	@Override
	public Equipe findOne(Long id) {
		try {
			return Banco.getEntityManager().find(Equipe.class, id);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			return null;
		}
	}

}
