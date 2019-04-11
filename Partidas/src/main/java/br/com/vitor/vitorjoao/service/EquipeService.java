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
		if (equipe.getId() == null) {
			repository.salvar(equipe);
		} else {
			repository.alterar(equipe);
		}
	}
}
