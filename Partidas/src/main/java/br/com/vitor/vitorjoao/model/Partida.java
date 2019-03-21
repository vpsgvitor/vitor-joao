package br.com.vitor.vitorjoao.model;

public class Partida {
	Long id;
	private Equipe equipe1;
	private Equipe equipe2;

	public Equipe getVencedor() {
		return equipe1.getGolsNaPartida() > equipe2.getGolsNaPartida() ? equipe1 : equipe2;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Equipe getEquipe1() {
		return equipe1;
	}

	public void setEquipe1(Equipe equipe1) {
		this.equipe1 = equipe1;
	}

	public Equipe getEquipe2() {
		return equipe2;
	}

	public void setEquipe2(Equipe equipe2) {
		this.equipe2 = equipe2;
	}

}