package Entity;

import java.util.List;

import bd.dbos.Usuario;

public class Partida {
	
	private int numeroBaralhos;
	private List<Usuario> listUsuarios;
	private Jogada jogada;
	
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
	
}
