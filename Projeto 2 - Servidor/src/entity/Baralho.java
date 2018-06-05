package entity;

import java.util.List;
/**
 * Classe que contem o Baralho da Jogada.
 * 
 * @author Felipe
 *
 */
public class Baralho {
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cartas == null) ? 0 : cartas.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return "Baralho [cartas=" + cartas + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Baralho other = (Baralho) obj;
		if (cartas == null) {
			if (other.cartas != null)
				return false;
		} else if (!cartas.equals(other.cartas))
			return false;
		return true;
	}
	

	private List<Carta> cartas;
	
	/**
	 * obtem Baralho
	 * 
	 * @return List<Carta>
	 */
	public List<Carta> getCartas() {
		return cartas;
	}
	
	/**
	 * seta Baralho
	 * 
	 * @return List<Carta>
	 */ 
	
	public void setCartas(List<Carta> cartas) {
		this.cartas = cartas;
	}
	
	
}
