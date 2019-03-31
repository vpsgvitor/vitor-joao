package br.com.vitor.vitorjoao.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "Partida")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Partida implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7069525206666599127L;

	@Id
	@GeneratedValue
	private Long id;

	@JoinColumn(name = "codEquipe1")
	private Equipe equipe1;

	@JoinColumn(name = "codEquipe2")
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