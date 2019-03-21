package br.com.vitor.vitorjoao.model;

public class Jogador {
	private Long id;
	private String nome;

	public Jogador() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Jogador(Long id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
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

}