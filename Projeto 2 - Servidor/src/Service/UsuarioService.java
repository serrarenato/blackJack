package Service;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Map;

import bd.dbos.Usuario;
import entity.Partida;

public class UsuarioService {
	
	PartidaService partidaService = new PartidaService();
	public void enviaListaPartidas(ObjectOutputStream transmissor) {
		try {
			Map<String, Partida> partidas = partidaService.listarPartidas();
			String resposta = new String();	
			for(String key: partidas.keySet()) {
				String x ="PAR:"+key+" "+partidas.get(key).getStatus()+":";
				resposta += x;
			}
			resposta+="EOF";
			transmissor.writeObject(resposta);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	public void criarPartida(ObjectOutputStream transmissor, String nome) {
		try {
			partidaService.novaPartida(nome);
			transmissor.writeObject(new String("SUC"));
		} catch (Exception e) {
			e.printStackTrace();
			try {
				transmissor.writeObject(new String("ERR"));
			} catch (IOException e1) {				
				e1.printStackTrace();
			}
		}
		
	}
	public void entrarPartida(ObjectOutputStream transmissor, String nome, String partida) {
		try {
			// TODO: buscar no banco usuario para criar o user
			Usuario usuario = new Usuario(nome, "a", "a","a");
			partidaService.setarUsuarioNaPartida(partida, usuario);
			
			String resposta = usuario.getEmail();
			transmissor.writeObject(resposta);
			
		} catch (Exception e) {
			e.printStackTrace();
			try {
				transmissor.writeObject(new String("ERR"));
			} catch (IOException e1) {				
				e1.printStackTrace();
			}
		}
	}

}
