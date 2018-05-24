package programa;

import bd.*;
import bd.dbos.*;
import javax.swing.JFrame;
import telas.JanelaLogin;
/**
 *onde era realizado o envio dos dados antes de ser implementada a interface.
 * @author melin
 */
public class Programa
{
    public static void main(String[] args)
    {
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