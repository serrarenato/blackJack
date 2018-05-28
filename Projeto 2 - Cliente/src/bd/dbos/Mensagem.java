package bd.dbos;

import java.io.Serializable;

public class Mensagem implements Serializable{
	private String protocolo;
	private String mensagem;

	public Mensagem(String protocolo, String mensagem) {
		super();
		this.protocolo = protocolo;
		this.mensagem = mensagem;
	}
	public Mensagem() {
		// TODO Auto-generated constructor stub
	}

	public String getProtocolo() {
		return protocolo;
	}

	public void setProtocolo(String protocolo) {
		this.protocolo = protocolo;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	@Override
	public String toString() {
		return protocolo + ":" + mensagem ;
	}
	

}
