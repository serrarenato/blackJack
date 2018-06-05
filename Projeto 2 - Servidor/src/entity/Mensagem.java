package entity;

import java.io.Serializable;

/**
 * Classe de mensagem, utilizada para troca de mensagem entre cliente e servidor
 * 
 * @author Felipe
 *
 */
public class Mensagem implements Serializable {
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

	/**
	 * Obter Protocolo da Mensagem
	 * 
	 * @return String
	 */
	public String getProtocolo() {
		return protocolo;
	}

	/**
	 * Setar Protocolo da Mensagem
	 * 
	 * @param protocolo
	 */
	public void setProtocolo(String protocolo) {
		this.protocolo = protocolo;
	}

	/**
	 * Obter Mensagem(conteudo)
	 * 
	 * @return String
	 */
	public String getMensagem() {
		return mensagem;
	}

	/**
	 * Setar Mensagem(conteudo)
	 * 
	 * @param mensagem
	 */
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	@Override
	public String toString() {
		return protocolo + ":" + mensagem;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((mensagem == null) ? 0 : mensagem.hashCode());
		result = prime * result + ((protocolo == null) ? 0 : protocolo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Mensagem other = (Mensagem) obj;
		if (mensagem == null) {
			if (other.mensagem != null)
				return false;
		} else if (!mensagem.equals(other.mensagem))
			return false;
		if (protocolo == null) {
			if (other.protocolo != null)
				return false;
		} else if (!protocolo.equals(other.protocolo))
			return false;
		return true;
	}

}
