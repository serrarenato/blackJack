package transmissor;

import java.io.Serializable;
import java.net.Socket;

import bd.dbos.Mensagem;

/**
 * realiza a implementação da conexão com o servidor, por meio da utilização d Scokets e coloca o endereço para a realização da conexão.
 * @author melin
 */

import bd.dbos.Usuario;

public class Solicitacao implements Serializable {

	private Usuario usuario = null;
	
    public Solicitacao(Usuario usuario) throws Exception {

    	if (usuario == null)
    		throw new Exception("Erro! Par�metro Usuario n�o foi adicionado no construtor!");
    
    	this.usuario = usuario;
    }
    
    /**
     * M�todo para enviar solicita��o / request para o servidor.
     * @param param tipo de solicita��o
     * @param usuario objeto de usu�rio
     * @return retorna SUC caso a solicita��o foi efetuada com sucesso ou ERR para erros!
     */
    public String Enviar(Mensagem mensagem) throws Exception {
    	
    	String ret = "";
    	

		Socket conexao = null;
		
		try {
//			//conexao = new Socket("172.16.13.127", 11111);
//			conexao = new Socket("localhost", 11111);
//			ObjectOutputStream transmissor = new ObjectOutputStream(conexao.getOutputStream());;
//    		ObjectInputStream receptor = new ObjectInputStream(conexao.getInputStream());
//    		
//    		transmissor.writeObject(usuario);
//    		transmissor.flush();
//    		
//    		ret = (String)receptor.readObject();
//    		
//    		transmissor.close();
//    		receptor.close();
//    		conexao.close();
			ClienteSocket cliente = ClienteSocket.getClienteSocket();
			cliente.enviaDados(mensagem);
		} catch (Exception e2) {
			
			throw new Exception(e2);
		}
		
		

    	
    	return ret;
    	
    }
    
   

}
