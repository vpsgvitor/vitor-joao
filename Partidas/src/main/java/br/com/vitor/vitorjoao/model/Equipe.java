package br.com.vitor.vitorjoao.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "Equipe")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Equipe implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1240205202852441460L;

	@Id
	@GeneratedValue
	private Long id;

	@Column(name = "Nome")
	private String nome;

	@Column(name = "Pontuacao")
	private Integer pontuacao;

	@Column(name = "golsNaPartida")
	private Integer golsNaPartida;

	public Equipe(Long id, String nome) {
		this.id = id;
		this.nome = nome;
	}

}