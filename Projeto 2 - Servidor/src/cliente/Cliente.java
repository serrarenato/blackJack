package cliente;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import Service.UsuarioService;
import bd.daos.UsuarioDAO;
import bd.dbos.Usuario;

/**
 * Classe para tratar os threads dos clientes.
 * @author Felipe
 *
 */
public class Cliente implements Runnable {

	// Atributos
	private Socket socket = null;
	private ObjectInputStream receptor = null; // Receptor
	private ObjectOutputStream transmissor = null; // Transmissor
	private UsuarioService usuarioService = new UsuarioService();;

	public Cliente(Socket socket) throws Exception {

		if (socket == null)
			throw new Exception("Erro! Insira um par�metro v�lido no construtor do cliente!");

		this.socket = socket;

		try {
			transmissor = new ObjectOutputStream(socket.getOutputStream());
			receptor = new ObjectInputStream(socket.getInputStream());
		} catch (Exception e) {
		}
	}

	@Override
	public void run() {

		UsuarioDAO dao = new UsuarioDAO();
		Usuario usuario = null;

		try {
			usuario = (Usuario) receptor.readObject();
		} catch (Exception e) {
			System.out.println("Erro ao converter receptor");
			return;
		}

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

		try {
			receptor.close();
			transmissor.close();
			socket.close();
		} catch (Exception e) {
		} // Sei que nunca vai dar erro...

	}

}
