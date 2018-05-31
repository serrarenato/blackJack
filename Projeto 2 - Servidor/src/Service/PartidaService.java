package Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import bd.dbos.Usuario;
import entity.Partida;
import exception.PartidaCriarException;
import exception.PartidaException;

public class PartidaService {
	private static Map<String, Partida> partidas = new HashMap<>();

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

	public void setarUsuarioNaPartida(String nome, Usuario usuario) throws PartidaException {
		Partida partida = new Partida(nome);
		if (!partidas.containsKey(nome)) 
			throw new PartidaException("Partida nao Existe");
		partidas.get(nome).getListUsuarios().add(usuario);
		usuario.setPartidaAtual(nome);
	}
	
	public List<Usuario> getUsuariosNaPartida(String nome) throws PartidaException {
		if (!partidas.containsKey(nome)) 
			throw new PartidaException("Partida nao Existe");
		return partidas.get(nome).getListUsuarios();
	}

}
