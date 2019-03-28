package br.com.vitor.vitorjoao.service;

import java.util.List;
import java.util.Random;

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
	private EquipeService equipeService;

	public List<Partida> listar() {
		return repository.listar();
	}

	public Partida findOne(Long id) {
		return repository.findOne(id);
	}

	public void salvar(Partida partida, boolean novo) {
		Partida partidaSalva = partida;
		if (!novo) {
			partidaSalva = this.merge(partida);
		} else {
			partidaSalva.setId(geraCodigo());
			partidaSalva.setEquipe1(equipeRepository.findOne(partida.getEquipe1().getId()));
			partidaSalva.setEquipe2(equipeRepository.findOne(partida.getEquipe2().getId()));
		}
		if (this.findOne(partidaSalva.getId()) == null) {
			repository.salvar(partida);
		} else {
			repository.alterar(partidaSalva);
		}
	}

	public void ajustaPlacar(Partida partida) {
		Equipe equipe1 = equipeRepository.findOne(partida.getEquipe1().getId());
		Equipe equipe2 = equipeRepository.findOne(partida.getEquipe2().getId());

		if (partida.getResultado() != null) {
			Integer pontEquipeWIN = equipeRepository.findOne(partida.getResultado().getId()).getPontuacao() != null
					? equipeRepository.findOne(partida.getResultado().getId()).getPontuacao()
					: 0;
			partida.getResultado().setPontuacao(pontEquipeWIN + 2);
		} else {
			partida.getEquipe1()
					.setPontuacao((equipe1.getPontuacao() != null
							? equipeRepository.findOne(partida.getEquipe1().getId()).getPontuacao()
							: 0) + 1);
			partida.getEquipe2()
					.setPontuacao((equipe2.getPontuacao() != null
							? equipeRepository.findOne(partida.getEquipe2().getId()).getPontuacao()
							: 0) + 1);
		}
		equipe1.setPontuacao(partida.getEquipe1().getPontuacao());
		equipe2.setPontuacao(partida.getEquipe2().getPontuacao());

		equipeRepository.alterar(equipe1);
		equipeRepository.alterar(equipe2);

		this.salvar(partida, false);
	}

	private Long geraCodigo() {
		Random rd = new Random();
		Long cod = Long.valueOf((rd.nextInt((333 - 0) + 1) + 0) * 6);

		if (repository.findOne(cod) != null) {
			Long.valueOf((rd.nextInt((333 - 0) + 1) + 0) * 6);
		}

		return cod;
	}

	private Partida merge(Partida partida) {
		Partida partidaMergeada = new Partida();
		Equipe equipe1 = equipeRepository.findOne(partida.getEquipe1().getId()) != null
				? equipeRepository.findOne(partida.getEquipe1().getId())
				: new Equipe();
		Equipe equipe2 = equipeRepository.findOne(partida.getEquipe2().getId()) != null
				? equipeRepository.findOne(partida.getEquipe2().getId())
				: new Equipe();

		partidaMergeada.setId(partida.getId() == null ? geraCodigo() : partida.getId());
		partidaMergeada.setEquipe1(equipeService.merge(equipe1, partida.getEquipe1()));
		partidaMergeada.setEquipe2(equipeService.merge(equipe2, partida.getEquipe2()));

		return partidaMergeada;
	}

}