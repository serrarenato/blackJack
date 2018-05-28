package Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import entity.Mensagem;

public class GerenciadorClientes extends Thread {
	private Socket cliente;
	private String Usuario;

	public GerenciadorClientes(Socket cliente) {

		this.cliente = cliente;
		start();
	}

	@Override
	public void run() {

		PrintWriter writer;
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
			// reader = new ObjectInputStream(cliente.getInputStream());
			writer = new PrintWriter(cliente.getOutputStream(), true);
			writer.println(new Mensagem("SUC", "Servidor conectado, favor se logar").toString());
			//writer.flush();
			String msg;

			while (true) {

				msg = reader.readLine();

				System.out.println(msg);
			}
			// } catch (ClassNotFoundException e1) {
			// System.out.println("Class not found");
			// e1.printStackTrace();

		} catch (IOException e1) {
			System.out.println("Cliente Fechou a conexao");
			e1.printStackTrace();
		}

		System.exit(0);

	}

}
