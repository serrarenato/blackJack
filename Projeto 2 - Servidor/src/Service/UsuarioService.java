package Service;

import java.util.List;
import java.util.Map;

import bd.dbos.Usuario;
import entity.Mensagem;
import entity.Partida;
import exception.PartidaException;

public class UsuarioService {

	PartidaService partidaService = new PartidaService();

	public Mensagem enviaListaPartidas() {
		String resposta = new String();
		try {
			Map<String, Partida> partidas = partidaService.listarPartidas();
			for (String key : partidas.keySet()) {
				String x = "PAR:" + key + " " + partidas.get(key).getStatus() + ":";
				resposta += x;
			}
			resposta += "EOF";

		} catch (Exception e) {
			e.printStackTrace();
			return new Mensagem("ERR", "");
		}
		return new Mensagem("PAR", resposta);

	}

	public Mensagem criarPartida(String nome) {
		try {
			partidaService.novaPartida(nome);

		} catch (Exception e) {
			return new Mensagem("ERR", "");
		}
		return new Mensagem("SUC", " ");

	}

	public Mensagem entrarPartida(Usuario usuario, String partida) {
		String resposta;
		try {

			Map<String, Partida> partidas = partidaService.listarPartidas();

			if (partidas.get(partida).getStatus() != "jogando") {
				return new Mensagem("ERR", "");
			}
			partidaService.setarUsuarioNaPartida(partida, usuario);

			resposta = usuario.getSaldo().toString();

		} catch (Exception e) {
			e.printStackTrace();
			return new Mensagem("ERR", "");
		}
		return new Mensagem("SUC", resposta);
	}

	public Mensagem listarUsuarioNaPartida(Usuario usuario) {
		Mensagem mensagem;
		try {

			List<Usuario> usuarios = partidaService.getUsuariosNaPartida(usuario.getPartidaAtual());
			mensagem = new Mensagem();
			mensagem.setProtocolo("SUC");
			String msg = "";
			for (Usuario user : usuarios) {
				msg += user.getNome() + ":";
			}
			msg = msg.substring(0, msg.length() - 1);
			mensagem.setMensagem(msg);

		} catch (PartidaException e) {
			e.printStackTrace();
			return new Mensagem("ERR", "");
		}
		return mensagem;

	}

	public void iniciarPartida(Usuario usuario, Map<String, GerenciadorClientes> listUsuarioGerenciador) {
		Mensagem mensagem = new Mensagem();
		try {

			String partida = usuario.getPartidaAtual();
			List<Usuario> usuarios = partidaService.getUsuariosNaPartida(partida);
			mensagem.setProtocolo("INI");
			for (Usuario usuarioPartida : usuarios) {
				GerenciadorClientes gerenciadorClientes= listUsuarioGerenciador.get(usuarioPartida.getNome());
				gerenciadorClientes.pararThreadListarPartida();
				gerenciadorClientes.enviaDados(mensagem);
			}
			
			Map<String, Partida> partidas = partidaService.listarPartidas();
			if (usuarios.size() > 4)
				partidas.get(partida).setNumeroBaralhos(2);
			else
				partidas.get(partida).setNumeroBaralhos(1);

		} catch (PartidaException e) {

			e.printStackTrace();
		//	mensagem.setProtocolo("ERR");
		//	return mensagem;
		}
		//mensagem.setProtocolo("SUC");

		//return mensagem;
	}

}
