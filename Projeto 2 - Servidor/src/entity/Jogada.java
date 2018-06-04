package entity;

import java.util.HashMap;
import java.util.Map;

public class Jogada {
	Baralho baralho;
	// Map<String usuario, <Aoosta, ListadeCartas>
	Map<String, Unitario> detalheJogada = new HashMap<>();

	Double total = 0d;
	
	public Baralho getBaralho() {
		return baralho;
	}

	public void setBaralho(Baralho baralho) {
		this.baralho = baralho;
	}

	public Map<String, Unitario> getDetalheJogada() {
		return detalheJogada;
	}

	public void setDetalheJogada(Map<String, Unitario> detalheJogada) {
		this.detalheJogada = detalheJogada;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}
	

}
