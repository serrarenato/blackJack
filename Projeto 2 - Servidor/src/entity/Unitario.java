package entity;

import java.util.ArrayList;
import java.util.List;

public class Unitario {

	Double Aposta = 0d;
	List<Carta> listaCartas = new ArrayList<>();

	
	public Unitario(Double aposta) {
		super();
		Aposta = aposta;
	}
	
	public Unitario() {
		
	}

	public Double getAposta() {
		return Aposta;
	}

	public void setAposta(Double aposta) {
		Aposta = aposta;
	}

	public List<Carta> getListaCartas() {
		return listaCartas;
	}

	public void setListaCartas(List<Carta> listaCartas) {
		this.listaCartas = listaCartas;
	}
}
