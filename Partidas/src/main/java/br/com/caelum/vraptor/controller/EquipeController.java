package br.com.caelum.vraptor.controller;

import java.util.List;
import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.vitor.vitorjoao.banco.Banco;
import br.com.vitor.vitorjoao.model.Equipe;

@Path("/equipe")
@Controller
public class EquipeController {

	@Inject
	Result result;

	@Get("/lista")
	public List<Equipe> lista() {
		return Banco.listaEquipes;
	}

	@Get("/novo")
	public void novo() {
	}

	@Get("/editar/{id}")
	public void editar(Long id) {
		result.include("equipe", Banco.getEquipeById(id));
		result.redirectTo(this).novo();
	}

	@Post("/salvar")
	public void salvar(Long id, String nome) {
		Banco.salvarEquipe(new Equipe(id, nome));
		result.forwardTo(IndexController.class).index();
	}

	@Get("/pontuacao")
	public List<Equipe> pontuacao() {
		return Banco.getPontuacao();
	}
}