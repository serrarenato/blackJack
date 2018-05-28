package programa;

import bd.*;
import bd.dbos.*;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

import bd.daos.*;
import cliente.Cliente;
import java.io.ObjectOutputStream;
import java.util.Scanner;

import Service.GerenciadorClientes;
import auxiliares.*;

public class Programa
{
    
    public static void main(String[] args)
    {
    	 ServerSocket servidor = null;
        try {
            servidor = new ServerSocket(11111);
            String mensagem = null;
            
            System.out.println("Iniciado servidor!");
            
           // MatadorDeServidor matador = new MatadorDeServidor();
            //Thread threadMatador = new Thread(matador);
            //threadMatador.start();
            
            while (true) {
                
                Socket conexao = servidor.accept();
                GerenciadorClientes gerenciadorClientes = new GerenciadorClientes(conexao);
                System.out.println("Aceitando novo cliente na porta " + conexao.getPort());
                
                try {
                   // Cliente cliente = new Cliente(conexao);
                  //  Thread thread = new Thread(cliente);
                  //  thread.start();
                } catch (Exception erro2) { } // Sei que nunca vai dar erro...
                
            }
            
        } catch (Exception erro) {
            System.err.println(erro.getMessage());
        }
        
    } 
}