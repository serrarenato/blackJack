package entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe com Detalhes de Cada Jogada em uma Partida
 * 
 * @author renato
 *
 */

public class Unitario {

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Aposta == null) ? 0 : Aposta.hashCode());
		result = prime * result + ((listaCartas == null) ? 0 : listaCartas.hashCode());
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
		Unitario other = (Unitario) obj;
		if (Aposta == null) {
			if (other.Aposta != null)
				return false;
		} else if (!Aposta.equals(other.Aposta))
			return false;
		if (listaCartas == null) {
			if (other.listaCartas != null)
				return false;
		} else if (!listaCartas.equals(other.listaCartas))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Unitario [Aposta=" + Aposta + ", listaCartas=" + listaCartas + "]";
	}

	Double Aposta = 0d;
	List<Carta> listaCartas = new ArrayList<>();

	public Unitario(Double aposta) {
		super();
		Aposta = aposta;
	}

	public Unitario() {

	}

	/**
	 * get Aposta da Jogada de cada usuario
	 * 
	 * @return Double
	 */
	public Double getAposta() {
		return Aposta;
	}

	/**
	 * Setar Aposta na jogada de cada usuario
	 * 
	 * @param Double
	 *            aposta
	 */
	public void setAposta(Double aposta) {
		Aposta = aposta;
	}

	/**
	 * Obtem Cartas de cada usuario
	 * 
	 * @return List<Carta>
	 */
	public List<Carta> getListaCartas() {
		return listaCartas;
	}

	/**
	 * Setar Cartas de cada usuario
	 * 
	 * @param List<Carta>
	 */

	public void setListaCartas(List<Carta> listaCartas) {
		this.listaCartas = listaCartas;
	}

}
