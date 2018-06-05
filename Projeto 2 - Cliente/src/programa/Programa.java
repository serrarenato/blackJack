package programa;

import javax.swing.JFrame;

import telas.JanelaLogin;
import transmissor.ClienteSocket;
/**
 *onde era realizado o envio dos dados antes de ser implementada a interface.
 * @author melin
 */
public class Programa
{
	static ClienteSocket cliente;
    public static void main(String[] args)
    {
    	try {
			cliente = ClienteSocket.getClienteSocket();
		} catch (Exception e) {
			e.printStackTrace();
		}
        JFrame telalogin = new JFrame("Login");
        JanelaLogin janela = new JanelaLogin(telalogin);
        
        try
        {
            telalogin.add(janela);
            telalogin.pack();
            telalogin.setLocationRelativeTo(janela);
            telalogin.setVisible(true);
            
        }
        catch (Exception erro)
        {
            System.err.println (erro);
        }
    } 
}