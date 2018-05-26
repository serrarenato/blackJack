package Service;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import entity.Partida;

public class UsuarioService {
	
	PartidaService partidaService = new PartidaService();
	public void enviaListaPartidas(ObjectOutputStream transmissor) {
		try {
			Map<String, Partida> partidas = partidaService.listarPartidas();
			transmissor.writeObject(new String("PAR"));
		
			for(String key: partidas.keySet()) {
				transmissor.writeObject(new String("PAR"));
				transmissor.writeObject(key);
				transmissor.writeObject(partidas.get(key).getStatus());				
			}
			transmissor.writeObject(new String("EOF"));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
