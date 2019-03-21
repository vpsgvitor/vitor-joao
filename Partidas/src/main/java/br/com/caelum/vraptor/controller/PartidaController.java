package br.com.caelum.vraptor.controller;

import java.util.List;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Patch;
import br.com.caelum.vraptor.Result;
import br.com.vitor.vitorjoao.banco.Banco;
import br.com.vitor.vitorjoao.model.Partida;

@Controller
@Patch("partida")
public class PartidaController {

	@Inject
	Result result;

	@Get("/")
	public List<Partida> lista() {
		return Banco.listaPartidas;
	}

	@Get()
	public void editar(Long id) {
		result.include("partida", Banco.getPartidaById(id));
	}
}