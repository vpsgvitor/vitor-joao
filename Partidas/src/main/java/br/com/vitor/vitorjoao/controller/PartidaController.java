package br.com.vitor.vitorjoao.controller;

import java.util.List;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.vitor.vitorjoao.model.Equipe;
import br.com.vitor.vitorjoao.model.Partida;
import br.com.vitor.vitorjoao.service.EquipeService;
import br.com.vitor.vitorjoao.service.PartidaService;

@Path("/")
@Controller
public class PartidaController {

	@Inject
	private Result result;

	@Inject
	private PartidaService service;

	@Inject
	private EquipeService equipeService;

	@Get("/")
	public void init() {
		result.redirectTo(this).lista();
	}

	@Get("/partida/")
	public List<Partida> lista() {
		return service.listar();
	}

	@Get("/partida/editar/{id}")
	public void editar(Long id) {
		result.include("partida", service.findOne(id));
	}

	@Get("/partida/novo")
	public void novo() {
		result.include("equipes", equipeService.listar());
	}

	@Get("/partida/pontuacao")
	public List<Equipe> pontuacao() {
		return equipeService.listar();
	}

	@Post("/partida/salvar")
	public void salvar(Partida partida) {
		service.salvar(partida, true);
		result.redirectTo(this).lista();
	}

	@Post("/partida/ajusta/placar")
	public void ajustaPlacar(Partida partida) {
		service.ajustaPlacar(partida);
		result.redirectTo(this).lista();
	}

}