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
	
	public static void salvar(Partida partida) {
		for (Partida p : listaPartidas) {
			if (p.getId() == partida.getId()) {
				p.setEquipe1(partida.getEquipe1());
				p.setEquipe2(partida.getEquipe2());
			}else {
				listaPartidas.add(partida);
			}
		}
	}
	public static Equipe getEquipeById(Long id) {
		for (Equipe e : listaEquipes) {
			if (e.getId() == id) {
				return e;
			}
		}
		return null;
	}

	public static void setEquipe(Equipe eq) {
		for (Equipe e : listaEquipes) {
			if (e.getId() == eq.getId()) {
				e.setNome(eq.getNome());
			}
		}
	}

	public void init() {
		Equipe eq1 = new Equipe();
		eq1.setId(9l);
		eq1.setNome("Vitor");
		eq1.setGolsNaPartida(6);

		Equipe eq2 = new Equipe();
		eq2.setId(9l);
		eq2.setNome("Joao");
		eq2.setGolsNaPartida(9);
		
		Partida p = new Partida();
		p.setId(6l);
		p.setEquipe1(eq1);
		p.setEquipe2(eq2);
		
		listaPartidas.add(p);
		listaEquipes.add(eq1);
		listaEquipes.add(eq2);

	}

}
