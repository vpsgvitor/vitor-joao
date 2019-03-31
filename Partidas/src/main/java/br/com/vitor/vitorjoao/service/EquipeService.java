package br.com.vitor.vitorjoao.service;

import java.util.List;

import javax.inject.Inject;

import br.com.vitor.vitorjoao.banco.EquipeBanco;
import br.com.vitor.vitorjoao.model.Equipe;

public class EquipeService {

	@Inject
	private EquipeBanco repository;

	public List<Equipe> listar() {
		return repository.listar();
	}

	public Equipe findOne(Long id) {
		return repository.findOne(id);
	}

	public void salvar(Equipe equipe) {
		if (this.findOne(equipe.getId()) == null) {
			repository.salvar(equipe);
		} else {
			repository.alterar(equipe);
		}
	}

//	private Long geraCodigo() {
//		Random rd = new Random();
//		Long cod = Long.valueOf((rd.nextInt((333 - 0) + 1) + 0) * 6);
//
//		if (repository.findOne(cod) != null) {
//			Long.valueOf((rd.nextInt((333 - 0) + 1) + 0) * 6);
//		}
//
//		return cod;
//	}

	/*
	 * É passado duas equipes, quando ajustado o placar, a partida vem apenas com o
	 * id e a quantidade de gols de cada equipe, este metodo 'sincroniza' essa
	 * equipe com o banco
	 */
	public Equipe merge(Equipe equipeSalva, Equipe equipePartida) {

		Equipe equipeMergeada = new Equipe();

		equipeMergeada.setId(equipeSalva.getId());
		equipeMergeada.setNome(equipeSalva.getNome());

		/*
		 * Verifica se possui pontuacao salva no banco e se possui pontuacao vinda da
		 * partida, se possui ambas, sao somadas
		 * 
		 * Se nao possui pontuacao no banco, permanece a da partida
		 * 
		 * Se nao possui pontuacao da partida, permanece a do banco
		 */
		if (equipeSalva.getPontuacao() != null) {
			equipeMergeada.setPontuacao(
					equipePartida.getPontuacao() != null ? equipePartida.getPontuacao() + equipeSalva.getPontuacao()
							: equipeSalva.getPontuacao());
		} else {
			equipeMergeada.setPontuacao(equipePartida.getPontuacao());
		}

		if (equipeSalva.getGolsNaPartida() != null) {
			equipeMergeada.setGolsNaPartida(equipeSalva.getGolsNaPartida() > 0 ? equipeSalva.getGolsNaPartida() : 0);
		} else {
			equipeMergeada
					.setGolsNaPartida(equipePartida.getGolsNaPartida() != null && equipePartida.getGolsNaPartida() > 0
							? equipePartida.getGolsNaPartida()
							: 0);
		}
		return equipeMergeada;
	}
}
