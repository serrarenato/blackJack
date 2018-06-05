package bd.daos;

import java.sql.SQLException;

import bd.BD;
import bd.core.MeuResultSet;
import bd.dbos.Usuario;

/**
 * Classe para acessar a tabela Usuarios do banco de dados.
 * 
 * @author Felipe
 *
 */
public class UsuarioDAO {
	/**
	 * Manipula o cadastro, atualiza��o de dados, exclus�o de dados atraves de dados
	 * recolhidos.
	 * 
	 * @param email
	 * @author Felipe
	 * @return true/false
	 * @throws Exception
	 */
	public boolean cadastrado(String email) throws Exception {
		boolean retorno = false;

		try {
			String sql;

			sql = "SELECT * " + "FROM USUARIOS " + "WHERE EMAIL = ?";

			BD.COMANDO.prepareStatement(sql);

			BD.COMANDO.setString(1, email);

			MeuResultSet resultado = (MeuResultSet) BD.COMANDO.executeQuery();

			retorno = resultado.first();

		} catch (SQLException erro) {
			throw new Exception("Erro ao procurar usuario.");
		}

		return retorno;
	}

	/**
	 * Incluir novo Usuario
	 * 
	 * @param usuario
	 * @throws Exception
	 */
	public void incluir(Usuario usuario) throws Exception {
		if (usuario == null)
			throw new Exception("Usuario nao fornecido.");

		try {
			String sql;

			sql = "INSERT INTO USUARIOS " + "(EMAIL,NOME,SENHA, SALDO) " + "VALUES " + "(?,?,?,?)";

			BD.COMANDO.prepareStatement(sql);

			BD.COMANDO.setString(1, usuario.getEmail());
			BD.COMANDO.setString(2, usuario.getNome());
			BD.COMANDO.setString(3, usuario.getSenha());
			BD.COMANDO.setDouble(4, usuario.getSaldo());

			BD.COMANDO.executeUpdate();
			BD.COMANDO.commit();
		} catch (SQLException erro) {
			System.out.println(erro);
			throw new Exception("Erro ao inserir usuario.");
		}
	}

	/**
	 * Excluir usuario por email
	 * 
	 * @param email
	 * @throws Exception
	 */
	public void excluir(String email) throws Exception {
		if (!cadastrado(email))
			throw new Exception("Nao cadastrado.");

		try {
			String sql;

			sql = "DELETE FROM USUARIOS " + "WHERE EMAIL=?";

			BD.COMANDO.prepareStatement(sql);

			BD.COMANDO.setString(1, email);

			BD.COMANDO.executeUpdate();
			BD.COMANDO.commit();
		} catch (SQLException erro) {
			throw new Exception("Erro ao excluir usuario.");
		}
	}

	/**
	 * Alterar um usuario
	 * 
	 * @param usuario
	 * @throws Exception
	 */
	public void alterar(Usuario usuario) throws Exception {
		if (usuario == null)
			throw new Exception("Usuario nao fornecido.");

		if (!cadastrado(usuario.getEmail()))
			throw new Exception("Nao cadastrado.");

		try {
			String sql;

			sql = "UPDATE USUARIOS " + "SET NOME=? " + "SET SENHA=? " + "WHERE EMAIL=?";

			BD.COMANDO.prepareStatement(sql);

			BD.COMANDO.setString(1, usuario.getNome());
			BD.COMANDO.setString(2, usuario.getSenha());
			BD.COMANDO.setString(3, usuario.getEmail());

			BD.COMANDO.executeUpdate();
			BD.COMANDO.commit();
		} catch (SQLException erro) {
			throw new Exception("Erro ao atualizar dados de usuario.");
		}
	}

	/*
	 * Alterar dinheiro do usuario
	 */
	public void alterarDinheiro(String nome, String email, Double saldo) throws Exception {
		if (email == null)
			throw new Exception("Usuario nao fornecido.");

		if (!cadastrado(email))
			throw new Exception("Nao cadastrado.");

		try {
			String sql;

			sql = "UPDATE USUARIOS " + "SET SALDO=? " + "WHERE EMAIL=? and nome =? ";

			BD.COMANDO.prepareStatement(sql);

			BD.COMANDO.setDouble(1, saldo);
			BD.COMANDO.setString(2, email);
			BD.COMANDO.setString(3, nome);

			BD.COMANDO.executeUpdate();
			BD.COMANDO.commit();
		} catch (SQLException erro) {
			throw new Exception("Erro ao atualizar dados de usuario.");
		}
	}

	/**
	 * Obtem um usuario do Banco pelo email
	 * 
	 * @param email
	 * @return Usuario
	 * @throws Exception
	 */
	public Usuario getUsuario(String email) throws Exception {
		Usuario usuario = null;

		try {
			String sql;

			sql = "SELECT * " + "FROM USUARIOS " + "WHERE EMAIL = ?";

			BD.COMANDO.prepareStatement(sql);

			BD.COMANDO.setString(1, email);

			MeuResultSet resultado = (MeuResultSet) BD.COMANDO.executeQuery();

			if (!resultado.first())
				throw new Exception("Nao cadastrado.");

			usuario = new Usuario(resultado.getString("EMAIL"), resultado.getString("NOME"),
					resultado.getString("SENHA"));
		} catch (SQLException erro) {
			throw new Exception("Erro ao procurar usuario.");
		}

		return usuario;
	}

	/**
	 * Obter usuario com email e senha fornecidos.
	 * 
	 * @param email
	 * @param senha
	 * @return Usuario
	 * @throws Exception
	 */
	public Usuario getUsuarioESenha(String email, String senha) throws Exception {
		boolean retorno = false;
		Usuario usuario = new Usuario();

		try {
			String sql;

			sql = "SELECT email, nome, senha, saldo, data " + "FROM USUARIOS " + "WHERE EMAIL = ? AND SENHA = ?";

			BD.COMANDO.prepareStatement(sql);

			BD.COMANDO.setString(1, email);
			BD.COMANDO.setString(2, senha);

			MeuResultSet resultado = (MeuResultSet) BD.COMANDO.executeQuery();

			retorno = resultado.first();
			if (retorno) {
				usuario.setEmail(resultado.getString(1));
				usuario.setNome(resultado.getString(2));
				usuario.setSenha(resultado.getString(3));
				usuario.setData(resultado.getDate(5));
				usuario.setSaldo(resultado.getDouble(4));
			} else
				return null;
			return usuario;

		} catch (SQLException erro) {
			erro.printStackTrace();
			throw new Exception("Erro ao procurar usuario.");
		}

	}

	

}