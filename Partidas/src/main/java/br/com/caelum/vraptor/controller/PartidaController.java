package br.com.caelum.vraptor.controller;

import java.util.List;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.vitor.vitorjoao.banco.Banco;
import br.com.vitor.vitorjoao.model.Partida;

@Path("/partida")
@Controller
public class PartidaController {

	@Inject
	private Result result;

	@Get("/")
	public List<Partida> lista() {
		Banco.init();
		return Banco.listaPartidas;
	}

	@Get("/editar/{id}")
	public void editar(Long id) {
		result.include("partida", Banco.getPartidaById(id));
	}
	
	@Post("/salvar")
	public void salvar(Partida partida) {
		
		result.redirectTo(this).lista();
	}
}