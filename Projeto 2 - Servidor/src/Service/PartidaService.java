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

public class PartidaService {
	private static Map<String, Partida> partidas = new HashMap<>();
	BaralhoService baralhoService = new BaralhoService();
	Jogada jogada = new Jogada();
	static PartidaService partidaService;

//	private PartidaService() {
//		
//	}
//	public static PartidaService getPartidaService() {
//		if (partidaService != null)
//			return partidaService;
//		else
//			return new PartidaService();
//	}
	public void novaPartida(String nome) throws PartidaCriarException {

		if (partidas.containsKey(nome))
			throw new PartidaCriarException("Partida ja Existe");
		else {
			Partida partida = new Partida(nome);
			partidas.put(nome, partida);
		}

	}

	public static Map<String, Partida> listarPartidas() {
		return partidas;
	}

	public static void setarUsuarioNaPartida(String nome, Usuario usuario) throws PartidaException {
		Partida partida = new Partida(nome);
		if (!partidas.containsKey(nome))
			throw new PartidaException("Partida nao Existe");
		partidas.get(nome).getListUsuarios().add(usuario);
		usuario.getCartasMao().clear();
		usuario.setPartidaAtual(nome);
	}

	public List<Usuario> getUsuariosNaPartida(String nome) throws PartidaException {
		if (!partidas.containsKey(nome))
			throw new PartidaException("Partida nao Existe");
		return partidas.get(nome).getListUsuarios();
	}

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

	public void inicioPartida(String nomePartida) {
		Partida partida = partidas.get(nomePartida);
		if (partida.getNumeroBaralhos() == 1) {
			jogada.setBaralho(baralhoService.criaUmBaralho());
		} else
			jogada.setBaralho(baralhoService.criaDoisBaralhos());
		jogada.setBaralho(baralhoService.embaralhar(jogada.getBaralho()));
		jogada.setTotal(0d);
		jogada.setTotal(0d);

	}

	public Carta getUmaCarta(Usuario usuario) {

		Carta carta = baralhoService.getPrimeiraCarta(jogada.getBaralho());
		usuario.getCartasMao().add(carta);
		if (usuario.getTotal()>21)
			usuario.setEstourou(true);
		return carta;
	}

}
