package br.com.vitor.vitorjoao.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Partida {
	Long id;
	private Equipe equipe1;
	private Equipe equipe2;

	public Equipe getResultado() {
		if (equipe1.getGolsNaPartida() > equipe2.getGolsNaPartida()) {
			return equipe1;
		} else if (equipe1.getGolsNaPartida() < equipe2.getGolsNaPartida()) {
			return equipe2;
		}
		return null;
	}

}