package br.com.vitor.vitorjoao.model;

public class Equipe {
	private Long id;
	private String nome;
	private Integer pontuacao;
	private Integer golsNaPartida;

	public Equipe() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Equipe(Long id, String nome, Integer pontuacao, Integer golsNaPartida) {
		super();
		this.id = id;
		this.nome = nome;
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