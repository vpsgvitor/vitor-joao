package br.com.vitor.vitorjoao.controller;

import java.util.List;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.vitor.vitorjoao.model.Equipe;
import br.com.vitor.vitorjoao.service.EquipeService;

@Path("/equipe")
@Controller
public class EquipeController {

	@Inject
	Result result;

	@Inject
	private EquipeService service;

	@Get("/lista")
	public List<Equipe> lista() {
		return service.listar();
	}

	@Get("/novo")
	public void novo() {
	}

	@Get("/editar/{id}")
	public void editar(Long id) {
		result.include("equipe", service.findOne(id));
		result.redirectTo(this).novo();
	}

	@Post("/salvar")
	public void salvar(Equipe equipe) {
		service.salvar(equipe);
		result.redirectTo(this).lista();
	}

}