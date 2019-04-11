package br.com.vitor.vitorjoao.service;

import java.util.List;

import javax.inject.Inject;

import br.com.vitor.vitorjoao.banco.EquipeBanco;
import br.com.vitor.vitorjoao.banco.PartidaBanco;
import br.com.vitor.vitorjoao.model.Equipe;
import br.com.vitor.vitorjoao.model.Partida;

public class PartidaService {

	@Inject
	private PartidaBanco repository;

	@Inject
	private EquipeBanco equipeRepository;

	@Inject

	public List<Partida> listar() {
		return repository.listar();
	}

	public Partida findOne(Long id) {
		return repository.findOne(id);
	}

	public void salvar(Partida partida, boolean novo) {
		Partida partidaSalva = partida;

		if (!novo) {
			repository.alterar(partidaSalva);
		} else {
			partidaSalva.setEquipe1(equipeRepository.findOne(partida.getEquipe1().getId()));
			partidaSalva.setEquipe2(equipeRepository.findOne(partida.getEquipe2().getId()));
			repository.salvar(partida);
		}
	}

	public void ajustaPlacar(Partida partida) {

		Equipe equipe1 = equipeRepository.findOne(partida.getEquipe1().getId());
		Equipe equipe2 = equipeRepository.findOne(partida.getEquipe2().getId());

		if (partida.getResultado() != null) {
			if (partida.getResultado().getId().equals(equipe1.getId())) {
				equipe1.setPontuacao(equipe1.getPontuacao() + 3);
			} else if (partida.getResultado().getId().equals(equipe2.getId())) {
				equipe2.setPontuacao(equipe2.getPontuacao() + 3);
			}
		} else {
			equipe1.setPontuacao(equipe1.getPontuacao() + 1);
			equipe2.setPontuacao(equipe2.getPontuacao() + 1);
		}

		equipeRepository.alterar(equipe1);
		equipeRepository.alterar(equipe2);

		this.salvar(partida, false);
	}
}