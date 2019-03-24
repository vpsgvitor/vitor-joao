package br.com.caelum.vraptor.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import br.com.vitor.vitorjoao.banco.Banco;

@Path("/")
@Controller
public class IndexController {

	private final Result result;

	protected IndexController() {
		this(null);
	}

	@Inject
	public IndexController(Result result) {
		this.result = result;
	}

	@Path("/")
	public void index() {
		result.redirectTo(EquipeController.class).lista();
	}
}