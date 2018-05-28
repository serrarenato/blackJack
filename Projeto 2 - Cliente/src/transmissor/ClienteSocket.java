package transmissor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;

import bd.dbos.Mensagem;

public class ClienteSocket {
	
	Socket cliente;
	static ClienteSocket clienteSocket;
	Mensagem mensagem;
	
	
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
						BufferedReader leitor = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
						//ObjectInputStream leitor = new ObjectInputStream(cliente.getInputStream());
						while(true) {
							//Mensagem mensagem;
							String mensagem;
							try {
								//mensagem = (Mensagem) leitor.readObject();
								mensagem =  leitor.readLine();
								if (mensagem !=null)
									System.out.println("Servidor disse:"+mensagem);
							} catch (Exception e) {
								e.printStackTrace();
								mensagem = "";
							}
							System.out.println(mensagem);
							//TODO: chama função com mensagem do servidor
							
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
	public void enviarMensagem(Mensagem mensagem) {
		
		PrintWriter transmissor;
		try {
			transmissor = new PrintWriter(cliente.getOutputStream(), true);
			transmissor.println(mensagem.toString());
			//transmissor.flush();
			this.mensagem=null;
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
