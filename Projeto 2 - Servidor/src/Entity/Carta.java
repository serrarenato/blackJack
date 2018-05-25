package Entity;

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

	public Naipe getNaipe() {
		return naipe;
	}

	public Numero getNumero() {
		return numero;
	}
}
