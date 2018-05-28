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
           //Usuario usuario = new Usuario ("xxx@gmail.com", "Lipe", "123oliveira4");
           // usuario.setNome("Jonnas Brothers");
           //BD.USUARIOS.incluir (usuario);
            //BD.USUARIOS.excluir(usuario);
            //BD.USUARIOS.alterar(usuario);
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