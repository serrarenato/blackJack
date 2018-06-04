package bd.dbos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entity.Carta;
import entity.Numero;

/**
 * Classe da entidade Usuario para controlar dados pessoais.
 * 
 * @author Felipe
 *
 */
public class Usuario implements Serializable {

	private String email;
	private String nome;
	private String senha;
	private String msg;
	private Double saldo;
	private Date data;
	private Double aposta = 0d;
	private List<Carta> cartasMao = new ArrayList<>();
	private Boolean parar = false;
	private Boolean estourou = false;

	/**
	 * Verifica se os pontos do Usuario estouraram
	 * 
	 * @return true/false
	 */
	public Boolean getEstourou() {
		return estourou;
	}

	/**
	 * Seta se os pontos estouraram
	 * 
	 * @param Boolean
	 *            - estourou
	 */
	public void setEstourou(Boolean estourou) {
		this.estourou = estourou;
	}

	/**
	 * Verifica se o usuario parou de comprar cartas.
	 * 
	 * @return true/false
	 */
	public Boolean getParar() {
		return parar;
	}

	/**
	 * Seta se o user Parou de comprar Cartas
	 * 
	 * @param parar
	 */
	public void setParar(Boolean parar) {
		this.parar = parar;
	}

	/**
	 * Obtem cartas da mao do user
	 * 
	 * @return List<Carta>
	 */
	public List<Carta> getCartasMao() {
		return cartasMao;
	}

	/**
	 * Setar cartas da mao do user
	 * 
	 * @param cartasMao
	 */
	public void setCartasMao(List<Carta> cartasMao) {
		this.cartasMao = cartasMao;
	}

	/**
	 * Obtem aposta do user
	 * 
	 * @return Double
	 */
	public Double getAposta() {
		return aposta;
	}

	/**
	 * Seta aposta do user
	 * 
	 * @param Double
	 *            aposta
	 */
	public void setAposta(Double aposta) {
		this.aposta = aposta;
	}

	private String PartidaAtual;

	/**
	 * Partida atual que o user esta
	 * 
	 * @param String
	 * 
	 */
	public String getPartidaAtual() {
		return PartidaAtual;
	}

	/**
	 * Setar partida para o user
	 * 
	 * @param partidaAtual
	 */
	public void setPartidaAtual(String partidaAtual) {
		PartidaAtual = partidaAtual;
	}

	/**
	 * Obter saldo do user
	 * 
	 * @return Double
	 */
	public Double getSaldo() {
		return saldo;
	}

	/**
	 * Setar saldo do user
	 * 
	 * @param saldo
	 */
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
	 * 
	 * @param email
	 * @param senha
	 * @param msg
	 *            para dizer o protocolo de solicita��o
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
	 * 
	 * @param nome
	 * @param email
	 * @param senha
	 * @param msg
	 *            para dizer o protocolo de solicita��o
	 * @throws Exception
	 */
	public Usuario(String nome, String email, String senha, String msg) throws Exception {

		if (nome.isEmpty() || email.isEmpty() || senha.isEmpty())
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

	/**
	 * Get email do user
	 * 
	 * @return String
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * setar email do user
	 * 
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * get nome do user
	 * 
	 * @return String
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Setar nome do user
	 * 
	 * @param nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Get senha do user
	 * 
	 * @return String
	 */
	public String getSenha() {
		return senha;
	}

	/**
	 * Setar senha do user
	 * 
	 * @param String
	 *            senha
	 */
	public void setSenha(String senha) {
		this.senha = senha;
	}

	/**
	 * Get total de cartas(pontos) na mao do user
	 * 
	 * @return
	 */
	public Integer getTotal() {
		Integer total = 0;
		boolean temCartaEspecial = false;

		for (Carta carta : cartasMao) {
			Numero numero = carta.getNumero();
			if (numero.equals(Numero.REI) || numero.equals(Numero.DAMA) || numero.equals(Numero.VALETE)) {
				total += 10;
				temCartaEspecial = true;
			} else if (numero.equals(Numero.AS)) {
				if (temCartaEspecial)
					total += 11;
				else
					total += 1;
			} else {

				total += numero.getValue();
			}

		}
		return total;
	}

}
