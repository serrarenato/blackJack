package Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;

import bd.daos.UsuarioDAO;
import bd.dbos.Usuario;
import entity.Mensagem;

public class GerenciadorClientes extends Thread {
	private Socket cliente;
	private Usuario usuario;
	private ObjectOutputStream output;
	private ObjectInputStream input;
	private UsuarioService usuarioService;
	
	public GerenciadorClientes(Socket cliente) {

		this.cliente = cliente;
		start();
	}

	@Override
	public void run() {

		try {
			output = new ObjectOutputStream(cliente.getOutputStream());
			output.flush();
			input = new ObjectInputStream(cliente.getInputStream());
			usuarioService = new UsuarioService();
			System.out.println("Cliente Conectado");
			//enviaDados(new Mensagem("SUC", "Servidor conectado, favor se logar"));
			while (true) {
				processaConexao();	
			}

		} catch (IOException e1) {
			System.out.println("Cliente Fechou a conexao");
			e1.printStackTrace();
		}
		finally
		{
			closeConnection(); 
		}

		System.exit(0);

	}

	private void processaConexao() {
	
		Mensagem mensagem;
		try 
		{	
			mensagem = ( Mensagem ) input.readObject(); 
			System.out.println(mensagem);			
			if (!mensagem.getProtocolo().isEmpty())
				comandos(mensagem);
			
			System.out.println(mensagem);

		}
		catch ( ClassNotFoundException e ) 
		{
			e.printStackTrace();
		} 		catch ( IOException e ) {
			closeConnection();
			stop();
		}

		

	}

	private void comandos(Mensagem mensagem) {
		
			UsuarioDAO dao = new UsuarioDAO();
	
			Mensagem enviaMensagem = new Mensagem();
	
			if (mensagem.getProtocolo().equals("CAD")) {

				try {
					String[] strings = mensagem.getMensagem().split(":");
					Usuario usuario = new Usuario(strings[0],strings[1],strings[2], "");
					usuario.setSaldo(1000d);
					dao.incluir(usuario);
					enviaMensagem.setProtocolo("SUC");
					enviaDados(enviaMensagem);

				} catch (Exception erro) {
					try {
						enviaMensagem.setProtocolo("ERR");
						enviaDados(enviaMensagem);
					} catch (Exception erro2) {
					}
				}

			} else if (mensagem.getProtocolo().equals("LOG")) {

				try {
					
					String[] strings = mensagem.getMensagem().split(":");

				
					this.usuario =  dao.getUsuarioESenha(strings[0], strings[1]);
					
					if (this.usuario!=null) {
						enviaMensagem.setProtocolo("SUC");
						enviaMensagem.setMensagem("");
						enviaDados(enviaMensagem);
					}else {
						enviaMensagem.setProtocolo("ERR");
						enviaDados(enviaMensagem);
					}

				} catch (Exception erro) {
					try {
						enviaMensagem.setProtocolo("ERR");
						enviaDados(enviaMensagem);
					} catch (Exception erro2) {
					}
				}
			} else if (mensagem.getProtocolo().equals("LST")) {
				// listar partidas
				enviaMensagem = usuarioService.enviaListaPartidas();
				enviaDados(enviaMensagem);
				
			} else if (mensagem.getProtocolo().equals("CRI")) {
				// criar partida
				String[] strings = mensagem.getMensagem().split(":");
				enviaMensagem = usuarioService.criarPartida(strings[0]);
				enviaDados(enviaMensagem);
				
			} else if (mensagem.getProtocolo().equals("ENT")) {
				// criar partida
				enviaMensagem = usuarioService.entrarPartida(usuario, mensagem.getMensagem());
				enviaDados(enviaMensagem);
			} else {

				try {
					enviaMensagem.setProtocolo("ERR");
					enviaDados(enviaMensagem);
				} catch (Exception erro) {
					erro.printStackTrace();
				}

			}
			
		}
		
	

	private void enviaDados(Mensagem message) {

		try {
			System.out.println("Enviando mensagem:"+message);
			output.writeObject(message);
			output.flush();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void closeConnection() {
		System.out.println("Terminando Conexao");

		try {
			output.close(); // close output stream
			input.close(); // close input stream
			cliente.close(); // close socket
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
}
