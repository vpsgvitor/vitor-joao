package br.com.vitor.vitorjoao.model;

import java.util.List;

public class Equipe {
	private Long id;
	private String nome;
	private List<Jogador> jogadores;
	private Integer pontuacao;
	private Integer golsNaPartida;

	public Equipe() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Equipe(Long id, String nome, List<Jogador> jogadores, Integer pontuacao, Integer golsNaPartida) {
		super();
		this.id = id;
		this.nome = nome;
		this.jogadores = jogadores;
		this.pontuacao = pontuacao;
		this.golsNaPartida = golsNaPartida;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Jogador> getJogadores() {
		return jogadores;
	}

	public void setJogadores(List<Jogador> jogadores) {
		this.jogadores = jogadores;
	}

	public Integer getPontuacao() {
		return pontuacao;
	}

	public void setPontuacao(Integer pontuacao) {
		this.pontuacao = pontuacao;
	}

	public Integer getGolsNaPartida() {
		return golsNaPartida;
	}

	public void setGolsNaPartida(Integer golsNaPartida) {
		this.golsNaPartida = golsNaPartida;
	}

}