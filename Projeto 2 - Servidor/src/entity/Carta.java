package entity;

/**
 * Esta classe é a carta propriamente dita no jogo com Naipe e Numero.
 * 
 * @author Felipe
 *
 */
public class Carta {
	private Naipe naipe;
	private Numero numero;

	public Carta(Naipe naipe, Numero numero) {
		this.naipe = naipe;
		this.numero = numero;
	}

	@Override
	public String toString() {
		return numero.toString() + " DE " + naipe.toString();
	}

	/**
	 * Obtem o Naipe
	 * 
	 * @return Naipe
	 */
	public Naipe getNaipe() {
		return naipe;
	}

	/**
	 * Obtem o Numero
	 * 
	 * @return Numero
	 */
	public Numero getNumero() {
		return numero;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((naipe == null) ? 0 : naipe.hashCode());
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
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
		Carta other = (Carta) obj;
		if (naipe != other.naipe)
			return false;
		if (numero != other.numero)
			return false;
		return true;
	}

}
