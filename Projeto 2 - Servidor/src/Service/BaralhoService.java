package Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import entity.Baralho;
import entity.Carta;
import entity.Naipe;
import entity.Numero;
/**
 * Classe responsável por gerenciar o Baralho do Jogo.
 * 
 * @author renato
 *
 */
public class BaralhoService {
/**
 * Criar um Baralho para uma partida
 * 
 * @return Baralho
 */
	public Baralho criaUmBaralho() {
		List<Carta> cartas = new ArrayList<>();
		for (Naipe cartaNaipe : Naipe.values())
			for (Numero cartaNumero : Numero.values())
				cartas.add(new Carta(cartaNaipe, cartaNumero));
		Baralho baralho = new Baralho();
		baralho.setCartas(cartas);
		return baralho;
	}
/**
 * Criar dois Baralhos para uma partida
 * 
 * @return Baralho
 */
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
/**
 * Metodo responsavel por Embaralhar um Baralho.	
 * @param baralho
 * @return Baralho
 */
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
/**
 * Metodo responsavel por pegar a primeira carta do baralho e retirar a mesma.
 * 
 * @param baralho
 * @return Carta
 */
	public Carta getPrimeiraCarta(Baralho baralho) {
		Carta carta = baralho.getCartas().get(0);
		baralho.getCartas().remove(0);
		return carta;
		
	}
}
