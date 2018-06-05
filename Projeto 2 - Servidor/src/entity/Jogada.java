package entity;

import java.util.HashMap;
import java.util.Map;

/**
 * Classe que corresponde a Jogada(Rodadas em uma partida);
 * 
 * @author Felipe
 *
 */
public class Jogada {

	Baralho baralho;


	Map<String, Unitario> detalheJogada = new HashMap<>();

	Double total = 0d;
	
	@Override
	public String toString() {
		return "Jogada [baralho=" + baralho + ", detalheJogada=" + detalheJogada + ", total=" + total + "]";
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((baralho == null) ? 0 : baralho.hashCode());
		result = prime * result + ((detalheJogada == null) ? 0 : detalheJogada.hashCode());
		result = prime * result + ((total == null) ? 0 : total.hashCode());
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
		Jogada other = (Jogada) obj;
		if (baralho == null) {
			if (other.baralho != null)
				return false;
		} else if (!baralho.equals(other.baralho))
			return false;
		if (detalheJogada == null) {
			if (other.detalheJogada != null)
				return false;
		} else if (!detalheJogada.equals(other.detalheJogada))
			return false;
		if (total == null) {
			if (other.total != null)
				return false;
		} else if (!total.equals(other.total))
			return false;
		return true;
	}



	/**
	 * Pegar Baralho
	 * 
	 * @return Baralho
	 */
	public Baralho getBaralho() {
		return baralho;
	}

	/**
	 * Setar Baralho
	 * 
	 * @param Baralho
	 *            baralho
	 */
	public void setBaralho(Baralho baralho) {
		this.baralho = baralho;
	}

	/**
	 * Pegar detalhes da Jogada
	 * 
	 * @return Map<String, Unitario>
	 */
	public Map<String, Unitario> getDetalheJogada() {
		return detalheJogada;
	}

	/**
	 * Setar detalhes da Jogada
	 * 
	 * @param Map<String,
	 *            Unitario> detalheJogada
	 */
	public void setDetalheJogada(Map<String, Unitario> detalheJogada) {
		this.detalheJogada = detalheJogada;
	}

	/**
	 * Get Total de Apostas na Jogada
	 * 
	 * @return Double
	 */
	public Double getTotal() {
		return total;
	}

	/**
	 * Setar total de apostas na Jogada
	 * 
	 * @param Double
	 *            total
	 */
	public void setTotal(Double total) {
		this.total = total;
	}
	

}
