package br.com.vitor.vitorjoao.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "Partida")
public class Partida implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne(targetEntity = br.com.vitor.vitorjoao.model.Equipe.class)
	@JoinColumn(name = "id_equipe1")
	private Equipe equipe1;

	@ManyToOne(targetEntity = br.com.vitor.vitorjoao.model.Equipe.class)
	@JoinColumn(name = "id_equipe2")
	private Equipe equipe2;

	public Partida() {
		super();
		// TODO Auto-generated constructor stub
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Partida other = (Partida) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Equipe getResultado() {
		if (equipe1.getGolsNaPartida() > equipe2.getGolsNaPartida()) {
			return equipe1;
		} else if (equipe1.getGolsNaPartida() < equipe2.getGolsNaPartida()) {
			return equipe2;
		}
		return null;
	}

}