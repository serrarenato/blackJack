package Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Entity.Baralho;
import Entity.Carta;
import Entity.Naipe;
import Entity.Numero;

public class BaralhoService {

	public Baralho criaUmBaralho() {
		List<Carta> cartas = new ArrayList<>();
		for (Naipe cartaNaipe : Naipe.values())
			for (Numero cartaNumero : Numero.values())
				cartas.add(new Carta(cartaNaipe, cartaNumero));
		Baralho baralho = new Baralho();
		baralho.setCartas(cartas);
		return baralho;
	}

	public Baralho criaDoisBaralhos() {
		List<Carta> cartas = new ArrayList<>();
		for (int x = 0; x < 2; x++)
			for (Naipe cartaNaipe : Naipe.values())
				for (Numero cartaNumero : Numero.values())
					cartas.add(new Carta(cartaNaipe, cartaNumero));
		Baralho baralho = new Baralho();
		baralho.setCartas(cartas);
		return baralho;
	}
	
	public Baralho embaralhar(Baralho baralho) {
		Random random = new Random();
		List<Carta> temp = new ArrayList<Carta>();
		List<Carta> cartas = baralho.getCartas();
		int j = 0;
		int numeroCartas = baralho.getCartas().size();
		for (int i = 0; i < numeroCartas; i++) {
			j = random.nextInt(numeroCartas);
			temp.add(cartas.get(j));
			cartas.remove(j);
		}
		Baralho newBaralho = new Baralho();
		newBaralho.setCartas(temp);
		return newBaralho;
	}
}
