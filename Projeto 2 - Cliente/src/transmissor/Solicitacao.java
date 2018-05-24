package transmissor;

/**
 * realiza a implementa√ß√£o da conex√£o com o servidor, por meio da utiliza√ß√£o d Scokets e coloca o endere√ßo para a realiza√ß√£o da conex√£o.
 * @author melin
 */

import bd.dbos.Usuario;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;

public class Solicitacao implements Serializable {

	private Usuario usuario = null;
	
    public Solicitacao(Usuario usuario) throws Exception {

    	if (usuario == null)
    		throw new Exception("Erro! Par‚metro Usuario n„o foi adicionado no construtor!");
    
    	this.usuario = usuario;
    }
    
    /**
     * MÈtodo para enviar solicitaÁ„o / request para o servidor.
     * @param param tipo de solicitaÁ„o
     * @param usuario objeto de usu·rio
     * @return retorna SUC caso a solicitaÁ„o foi efetuada com sucesso ou ERR para erros!
     */
    public String Enviar(Usuario usuario) throws Exception {
    	
    	String ret = "";
    	

		Socket conexao = null;
		
		try {
			//conexao = new Socket("172.16.13.127", 11111);
			conexao = new Socket("localhost", 11111);
			ObjectOutputStream transmissor = new ObjectOutputStream(conexao.getOutputStream());;
    		ObjectInputStream receptor = new ObjectInputStream(conexao.getInputStream());
    		
    		transmissor.writeObject(usuario);
    		transmissor.flush();
    		
    		ret = (String)receptor.readObject();
    		
    		transmissor.close();
    		receptor.close();
    		conexao.close();
		} catch (Exception e2) {
			
			throw new Exception(e2);
		}
		
		

    	
    	return ret;
    	
    }
    
   

}
