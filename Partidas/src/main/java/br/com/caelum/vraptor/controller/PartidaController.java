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
		return Banco.listaPartidas;
	}

	@Get("/editar/{id}")
	public void editar(Long id) {
		result.include("partida", Banco.getPartidaById(id));
	}

	@Post("/salvar")
	public void salvar(Partida partida) {
		Banco.salvarPartida(partida);
		result.redirectTo(this).lista();
	}

	@Get("/novo")
	public void novo() {
		result.include("equipes", Banco.listaEquipes);

	}

	@Post("/novo")
	public void novo(Long idEquipe01, Long idEquipe02) {
		Banco.addPartida(new Partida(Banco.getEquipeById(idEquipe01), Banco.getEquipeById(idEquipe02)));
		result.redirectTo(this).lista();
	}
}