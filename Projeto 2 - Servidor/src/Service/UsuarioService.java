package Service;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Map;

import bd.daos.UsuarioDAO;
import bd.dbos.Usuario;
import entity.Mensagem;
import entity.Partida;

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
			
			if (partidas.get(partida).getStatus()!="jogando"){
				return new Mensagem("ERR","");
			}
			partidaService.setarUsuarioNaPartida(partida, usuario);
			
			resposta = usuario.getSaldo().toString();
			
			
		} catch (Exception e) {
			e.printStackTrace();
			return new Mensagem("ERR","");
		}
		return new Mensagem("SUC",resposta);
	}

}
