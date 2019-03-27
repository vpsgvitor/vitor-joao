package br.com.vitor.vitorjoao.banco;

import java.util.List;

import br.com.vitor.vitorjoao.dao.PartidaDao;
import br.com.vitor.vitorjoao.model.Partida;

public class PartidaBanco implements PartidaDao {

	@Override
	public void salvar(Partida dado) {
		Banco.listaPartidas.add(dado);
	}

	@Override
	public void alterar(Partida dado) {

		for (Partida partidaBanco : Banco.listaPartidas) {
			if (partidaBanco.getId().equals(dado.getId())) {
				partidaBanco.setId(dado.getId());
				partidaBanco.setEquipe1(dado.getEquipe1());
				partidaBanco.setEquipe2(dado.getEquipe2());
			}
		}

	}

	@Override
	public void excluir(Partida dado) {
		Banco.listaPartidas.remove(dado);
	}

	@Override
	public List<Partida> listar() {
		return Banco.listaPartidas;
	}

	@Override
	public Partida findOne(Long id) {
		for (Partida partidaBanco : Banco.listaPartidas) {
			if (partidaBanco.getId().equals(id)) {
				return partidaBanco;
			}
		}
		return null;
	}

}
