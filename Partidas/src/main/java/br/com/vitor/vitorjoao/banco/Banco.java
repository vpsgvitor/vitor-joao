package br.com.vitor.vitorjoao.banco;

import java.util.ArrayList;
import java.util.List;

import br.com.vitor.vitorjoao.model.Equipe;
import br.com.vitor.vitorjoao.model.Partida;

public class Banco {

	public static List<Partida> listaPartidas = new ArrayList<Partida>();
	public static List<Equipe> listaEquipes = new ArrayList<Equipe>();
	private static boolean aux = false;

// Métodos onde quando existe, edita, quando não existe, adiciona!

	public static void salvarEquipe(Equipe equipe) {
		aux = true;
		for (Equipe e : listaEquipes) {
			if (e.getId() == equipe.getId()) {
				e.setNome(equipe.getNome());
				aux = false;
			}
		}
		if (aux) {
			addEquipe(equipe);
		}
	}

	public static void salvarPartida(Partida partida) {
		aux = true;
		for (Partida p : listaPartidas) {
			if (p.getId() == partida.getId()) {
				p.setEquipe1(partida.getEquipe1());
				p.setEquipe2(partida.getEquipe2());
				aux = false;
			}
		}
		if (aux) {
			addPartida(partida);
		}
	}

//Métodos getById	

	public static Partida getPartidaById(Long id) {
		for (Partida p : listaPartidas) {
			if (p.getId() == id) {
				return p;
			}
		}
		return null;
	}

	public static Equipe getEquipeById(Long id) {
		for (Equipe e : listaEquipes) {
			if (e.getId() == id) {
				return e;
			}
		}
		return null;
	}

//Metodos add, já que sem o banco, fode a porra do id!

	public static void addEquipe(Equipe equipe) {
		equipe.setId(Long.valueOf(listaEquipes.size() + 1));
		listaEquipes.add(equipe);
	}

	public static void addPartida(Partida partida) {
		partida.setId(Long.valueOf(listaPartidas.size() + 1));
		listaPartidas.add(partida);
	}
}