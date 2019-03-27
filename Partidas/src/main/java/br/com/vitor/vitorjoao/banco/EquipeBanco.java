package br.com.vitor.vitorjoao.banco;

import java.util.List;

import br.com.vitor.vitorjoao.dao.EquipeDao;
import br.com.vitor.vitorjoao.model.Equipe;

public class EquipeBanco implements EquipeDao {

	@Override
	public void salvar(Equipe dado) {
		Banco.listaEquipes.add(dado);
	}

	@Override
	public void alterar(Equipe dado) {

		for (Equipe equipeBanco : Banco.listaEquipes) {
			if (equipeBanco.getId().equals(dado.getId())) {
				equipeBanco.setId(dado.getId());
				equipeBanco.setNome(dado.getNome());
				equipeBanco.setPontuacao(dado.getPontuacao());
				equipeBanco.setGolsNaPartida(dado.getGolsNaPartida());
			}
		}

	}

	@Override
	public void excluir(Equipe dado) {
		Banco.listaEquipes.remove(dado);
	}

	@Override
	public List<Equipe> listar() {
		return Banco.listaEquipes;
	}

	@Override
	public Equipe findOne(Long id) {
		for (Equipe equipeBanco : Banco.listaEquipes) {
			if (equipeBanco.getId().equals(id)) {
				return equipeBanco;
			}
		}
		return null;
	}

}
