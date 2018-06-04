package Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import entity.Baralho;
import entity.Carta;
import entity.Naipe;
import entity.Numero;

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
		int numeroCartas = baralho.getCartas().size()-1;
		int i=0;
		try {
		for ( i = 0; i <= numeroCartas; i++) {
			j = random.nextInt( baralho.getCartas().size());
			temp.add(cartas.get(j));
			cartas.remove(j);
		}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("i "+i);
			System.out.println("baralho "+baralho.getCartas().size());
		}
		Baralho newBaralho = new Baralho();
		newBaralho.setCartas(temp);
		return newBaralho;
	}
	
	public Carta getPrimeiraCarta(Baralho baralho) {
		Carta carta = baralho.getCartas().get(0);
		baralho.getCartas().remove(0);
		return carta;
		
	}
}
