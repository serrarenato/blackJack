package Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import bd.dbos.Usuario;
import entity.Carta;
import entity.Jogada;
import entity.Partida;
import entity.Unitario;
import exception.PartidaCriarException;
import exception.PartidaException;

/**
 * Classe responsável por Gerenciar as Partidas
 * 
 * @author renato
 *
 */
public class PartidaService {
	
	private static Map<String, Partida> partidas = new HashMap<>(); // partida deve ser estatico para todos os Jogadores poderem ver as partidas existentes
	BaralhoService baralhoService = new BaralhoService();
	Jogada jogada = new Jogada();
	static PartidaService partidaService;

/**
 * Criar uma nova Partida - metodo estatico
 * 
 * @param nome
 * @throws PartidaCriarException
 */
	public static void novaPartida(String nome) throws PartidaCriarException {

		if (partidas.containsKey(nome))
			throw new PartidaCriarException("Partida ja Existe");
		else {
			Partida partida = new Partida(nome);
			partidas.put(nome, partida);
		}

	}
/**
 * Metodo estatico para listar Partidas Disponiveis
 * 
 * @return Map<String, Partida> = Map<nome, Partida>
 */
	public static Map<String, Partida> listarPartidas() {
		return partidas;
	}
/**
 * Metodo estatico para inserir um usuario na partida
 * 
 * @param nome
 * @param usuario
 * @throws PartidaException
 * 
 */
	public static void setarUsuarioNaPartida(String nome, Usuario usuario) throws PartidaException {
		Partida partida = new Partida(nome);
		if (!partidas.containsKey(nome))
			throw new PartidaException("Partida nao Existe");
		partidas.get(nome).getListUsuarios().add(usuario);
		usuario.getCartasMao().clear();
		usuario.setPartidaAtual(nome);
	}
/**
 * Obter os Usuarios inscritos em uma partida
 * 
 * @param nome
 * @return List<Usuario>  - lista de usuarios da partida
 * @throws PartidaException
 */
	public List<Usuario> getUsuariosNaPartida(String nome) throws PartidaException {
		if (!partidas.containsKey(nome))
			throw new PartidaException("Partida nao Existe");
		return partidas.get(nome).getListUsuarios();
	}
/**
 * Metodo responsável por inserir as apostas dos jogadores em cada Jogada da Partida.
 * 
 * @param nomePartida
 * @param usuario
 * @param aposta
 */
	public void setApostaNaPartida(String nomePartida, String usuario, Double aposta) {
		Partida partida = partidas.get(nomePartida);
		Double total = partida.getJogada().getTotal();
		total += aposta;
		partida.getJogada().setTotal(total);
		for (Usuario user : partida.getListUsuarios()) {
			if (user.getNome().equals(usuario)) {
				user.setAposta(aposta);
			}
		}
		Jogada jogada = partida.getJogada();
		if (jogada.getDetalheJogada().containsKey(usuario))
			jogada.getDetalheJogada().get(usuario).setAposta(aposta);
		else
			jogada.getDetalheJogada().put(usuario, new Unitario(aposta));
	}
/**
 * Método responsável por setar as variaveis inicias antes de iniciar uma partida.
 * 
 * @param nomePartida
 */
	public void inicioPartida(String nomePartida) {
		Partida partida = partidas.get(nomePartida);
		if (partida.getNumeroBaralhos() == 1) {
			jogada.setBaralho(baralhoService.criaUmBaralho());
		} else
			jogada.setBaralho(baralhoService.criaDoisBaralhos());
		jogada.setBaralho(baralhoService.embaralhar(jogada.getBaralho()));
		jogada.setTotal(0d);
		partida.setStatus("iniciada");
		

	}
/**
 * Metodo responsável por pegar uma carta do Baralho para um usuario.
 * 
 * @param usuario
 * @return Carta
 */
	public Carta getUmaCarta(Usuario usuario) {

		Carta carta = baralhoService.getPrimeiraCarta(jogada.getBaralho());
		usuario.getCartasMao().add(carta);
		if (usuario.getTotal()>21)
			usuario.setEstourou(true);
		return carta;
	}

}
