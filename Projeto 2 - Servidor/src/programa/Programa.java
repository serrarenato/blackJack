package programa;

import java.net.ServerSocket;
import java.net.Socket;

import Service.GerenciadorClientes;

public class Programa
{
    
    public static void main(String[] args)
    {
    	 ServerSocket servidor = null;
        try {
            servidor = new ServerSocket(11111);
            String mensagem = null;
            
            System.out.println("Iniciado servidor!");
            

            
            while (true) {
                
                Socket conexao = servidor.accept();
                GerenciadorClientes gerenciadorClientes = new GerenciadorClientes(conexao);
                System.out.println("Aceitando novo cliente na porta " + conexao.getPort());
       
                
            }
            
        } catch (Exception erro) {
            System.err.println(erro.getMessage());
        }
        
    } 
}