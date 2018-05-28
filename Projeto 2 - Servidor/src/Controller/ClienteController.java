package Controller;

import bd.dbos.Usuario;
import entity.Mensagem;

public class ClienteController {

	public void gerenciadorRequisicao(Mensagem msg) {
		if (usuario.getMsg().equals("CAD")) {

			try {

				dao.incluir(usuario);
				transmissor.writeObject(new String("SUC"));

			} catch (Exception erro) {
				try {
					transmissor.writeObject(new String("ERR"));
				} catch (Exception erro2) {
				}
			}

		} else if (usuario.getMsg().equals("LOG")) {

			try {
				boolean existe = true;//dao.getUsuarioESenha(usuario.getEmail(), usuario.getSenha());

				if (existe)
					transmissor.writeObject(new String("SUC"));
				else
					transmissor.writeObject(new String("ERR"));

			} catch (Exception erro) {
				try {
					transmissor.writeObject("ERR");
				} catch (Exception erro2) {
				}
			}
		} else if (usuario.getMsg().equals("LST")) {
			// listar partidas
			usuarioService.enviaListaPartidas(transmissor);
			
		} else if (usuario.getMsg().equals("CRI")) {
			// criar partida
			usuarioService.criarPartida(transmissor, usuario.getNome());			
		} else {

			try {
				transmissor.writeObject(new String("ERR"));
			} catch (Exception erro) {
			}

		}
		
	}

}

}
