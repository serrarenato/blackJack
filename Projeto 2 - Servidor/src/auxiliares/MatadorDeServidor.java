package auxiliares;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Classe para ler entrada do teclado e ver se o usuário digitou certo parâmetro para finalizar o programa.
 * @author Felipe
 *
 */
public class MatadorDeServidor implements Runnable {

	@Override
	public void run() {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
		
			String cmd = null;
			
			try {
				cmd = reader.readLine();
				cmd = cmd.toLowerCase();
			} catch (IOException e) { }
			
			if (cmd.equals("sair"))
				break;
			
		}
		
		System.exit(0);
		
	}
	
}
