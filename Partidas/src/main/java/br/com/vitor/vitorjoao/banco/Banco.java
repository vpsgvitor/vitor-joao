package br.com.vitor.vitorjoao.banco;

import java.util.ArrayList;
import java.util.List;

import br.com.vitor.vitorjoao.model.Equipe;
import br.com.vitor.vitorjoao.model.Partida;

public class Banco {

	public static List<Partida> listaPartidas = new ArrayList<Partida>();
	public static List<Equipe> listaEquipes = new ArrayList<Equipe>();

	public static Partida getPartidaById(Long id) {
		for (Partida p : listaPartidas) {
			if (p.getId() == id) {
				return p;
			}
		}
		return null;
	}

	public void init() {
		Equipe eq1 = new Equipe();
		eq1.setNome("Vitor");

		Equipe eq2 = new Equipe();
		eq1.setNome("jao");

		listaEquipes.add(eq1);
		listaEquipes.add(eq2);

	}

}
