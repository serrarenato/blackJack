package entity;

import java.util.ArrayList;
import java.util.List;

import bd.dbos.Usuario;
/**
 * Classe que contem cada Partida do jogo
 * 
 * @author Felipe
 *
 */

public class Partida {
	final String INICIADA =  "iniciada";
	final String NAO_INICIADA =  "jogando";

	private int numeroBaralhos;
	private List<Usuario> listUsuarios;
	private Jogada jogada;
	private int numeroJogada;
	private String nome;
	private String status;

	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Partida(String nome) {
		this.nome = nome;
		this.numeroJogada=1;
		this.numeroBaralhos=1;
		this.status=NAO_INICIADA;
		this.numeroJogada=1;
		this.listUsuarios = new ArrayList<>();
		this.jogada = new Jogada();
	}

	public int getNumeroJogada() {
		return numeroJogada;
	}

	public void setNumeroJogada(int numeroJogada) {
		this.numeroJogada = numeroJogada;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Usuario> getListUsuarios() {
		return listUsuarios;
	}

	public void setListUsuarios(List<Usuario> listUsuarios) {
		this.listUsuarios = listUsuarios;
	}

	public Jogada getJogada() {
		return jogada;
	}

	public void setJogada(Jogada jogada) {
		this.jogada = jogada;
	}

	public int getNumeroBaralhos() {
		return numeroBaralhos;
	}

	public void setNumeroBaralhos(int numeroBaralhos) {
		this.numeroBaralhos = numeroBaralhos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((jogada == null) ? 0 : jogada.hashCode());
		result = prime * result + ((listUsuarios == null) ? 0 : listUsuarios.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + numeroBaralhos;
		result = prime * result + numeroJogada;
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		if (jogada == null) {
			if (other.jogada != null)
				return false;
		} else if (!jogada.equals(other.jogada))
			return false;
		if (listUsuarios == null) {
			if (other.listUsuarios != null)
				return false;
		} else if (!listUsuarios.equals(other.listUsuarios))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (numeroBaralhos != other.numeroBaralhos)
			return false;
		if (numeroJogada != other.numeroJogada)
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Partida [INICIADA=" + INICIADA + ", NAO_INICIADA=" + NAO_INICIADA + ", numeroBaralhos=" + numeroBaralhos
				+ ", listUsuarios=" + listUsuarios + ", jogada=" + jogada + ", numeroJogada=" + numeroJogada + ", nome="
				+ nome + ", status=" + status + "]";
	}
	



}
