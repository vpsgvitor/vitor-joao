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
public class Equipe {
	private Long id;
	private String nome;
	private Integer pontuacao;
	private Integer golsNaPartida;

	public Equipe(Long id, String nome) {
		this.id = id;
		this.nome = nome;
	}

}