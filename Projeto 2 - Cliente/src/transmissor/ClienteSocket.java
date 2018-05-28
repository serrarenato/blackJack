package transmissor;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import bd.dbos.Mensagem;

public class ClienteSocket {
	
	Socket cliente;
	static ClienteSocket clienteSocket;
	Mensagem mensagem;
	private ObjectOutputStream output;
	private ObjectInputStream input;
	
	
	public static ClienteSocket getClienteSocket() {
		if (clienteSocket== null)
			clienteSocket=new ClienteSocket();
		return clienteSocket;
	}

	private ClienteSocket() {

		String ret = "";
		try {

			this.cliente = new Socket("localhost", 11111);
			// lendo mensagens do Servidor
			new Thread() {
				@Override
				public void run() {
					try {
						output = new ObjectOutputStream(cliente.getOutputStream());
						output.flush();
						input = new ObjectInputStream(cliente.getInputStream());

						while (true) {
							processaConexao();	
						}

					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}.start();
			
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}
	
	private void processaConexao() {
		
		Mensagem mensagem = new Mensagem();
		try 
		{			
			mensagem = ( Mensagem ) input.readObject(); 
			System.out.println(mensagem);
			//TODO metodo para verificar mensagem

		}
		catch ( ClassNotFoundException|IOException e ) 
		{
			e.printStackTrace();
		} 

		

	}

	public void enviaDados(Mensagem message) {

		try {
			output.writeObject(message);
			output.flush();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public Mensagem getMessagem() {
		return mensagem;
		
	}
	public void waitMessagem() {
		while((mensagem = clienteSocket.getMessagem())==null);
	}

	public void close() {

		try {
			cliente.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
