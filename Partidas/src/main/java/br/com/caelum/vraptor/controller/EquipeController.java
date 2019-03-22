package br.com.caelum.vraptor.controller;

import java.util.List;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.vitor.vitorjoao.banco.Banco;
import br.com.vitor.vitorjoao.model.Equipe;

@Path("/equipe")
@Controller
public class EquipeController {
	
	@Get("/")
	public List<Equipe> lista() {
		return Banco.listaEquipes;
	}
	
	@Get("/novo")
	public void novo() {
		// Mapeado para JSP
	}
	
	@Post("/salvar")
	public void salvar() {
		// TODO Auto-generated method stub
	}
	
	@Get("/pontuacao")
	public void pontuacao() {
		// TODO Auto-generated method stub
	}

}
