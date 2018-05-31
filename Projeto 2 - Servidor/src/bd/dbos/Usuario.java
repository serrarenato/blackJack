package bd.dbos;

import java.io.Serializable;
import java.util.Date;

import javax.swing.JPasswordField;
import javax.swing.JTextField;


/**
 * Classe da entidade Usuario para controlar dados pessoais para cadastro e login.
 * @author Felipe
 *
 */
public class Usuario implements Serializable
{
    
    private String email;
    private String nome;
    private String senha;
    private String msg;
    private Double saldo;
    private Date data;
    
    private String PartidaAtual;
    
    public String getPartidaAtual() {
		return PartidaAtual;
	}

	public void setPartidaAtual(String partidaAtual) {
		PartidaAtual = partidaAtual;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	/**
     * Construtor da entidade Usuario para LOGIN.
     * @param email
     * @param senha
     * @param msg para dizer o protocolo de solicita��o
     * @throws Exception
     */
    
    public Usuario(String email, String senha, String msg) throws Exception {
    	
    	if (email.isEmpty() || senha.isEmpty() || msg.isEmpty())
    		throw new Exception("Erro! Construtor com par�metro(s) nulo(s)!");
    	
        this.email = email;
        this.senha = senha;
        this.msg = msg;
        
    }
    
    /**
     * Construtor da entidade Usuario para CADASTRAR.
     * @param nome
     * @param email
     * @param senha
     * @param msg para dizer o protocolo de solicita��o
     * @throws Exception
     */
    public Usuario(String nome, String email, String senha, String msg) throws Exception {
        
    	if (nome.isEmpty() || email.isEmpty() || senha.isEmpty() )
    		throw new Exception("Erro! Construtor com par�metro(s) nulo(s)!");
    	
    	this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.msg = msg;
        
    }

	public Usuario() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((msg == null) ? 0 : msg.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((senha == null) ? 0 : senha.hashCode());
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
		Usuario other = (Usuario) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (msg == null) {
			if (other.msg != null)
				return false;
		} else if (!msg.equals(other.msg))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (senha == null) {
			if (other.senha != null)
				return false;
		} else if (!senha.equals(other.senha))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Usuario [email=" + email + ", nome=" + nome + ", senha=" + senha + ", msg=" + msg + ", hashCode()="
				+ hashCode() + ", getClass()=" + getClass() + ", toString()=" + super.toString() + "]";
	}

	public String getMsg() {
		return msg;
	}
	
	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}

	
    
   
}
