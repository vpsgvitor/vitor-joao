package br.com.caelum.vraptor.controller;

import java.lang.ProcessBuilder.Redirect;
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
		// Mapeado para JSP
	}

	@Get("/editar/{id}")
	public void editar(Long id) {
		result.include("equipe", Banco.getEquipeById(id));
		result.redirectTo(this).novo();
	}

	@Post("/salvar")
	public void salvar(Equipe equipe) {
		Banco.setEquipe(equipe);
		result.forwardTo(IndexController.class).index();
	}
	
	@Get("/pontuacao")
	public void pontuacao() {
		// TODO Auto-generated method stub
	}
}
