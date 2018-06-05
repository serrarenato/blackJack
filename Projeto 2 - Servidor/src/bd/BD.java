package bd;

import bd.core.*;
import bd.daos.*;
/**
 * Esta classe realiza a conex�o com o servidor, utilizando o login fornecido pelo professor.
 * @author Felipe
 */
public class BD
{
    public static final MeuPreparedStatement COMANDO;
    public static final UsuarioDAO USUARIOS; 

    static
    {
    	MeuPreparedStatement comando = null;
     	UsuarioDAO usuarios  = null; 

    	try
        {
            comando =
            new MeuPreparedStatement (
            "com.microsoft.sqlserver.jdbc.SQLServerDriver",
            "jdbc:sqlserver://fs5:1433;databasename=poo201845",
            "poo201845", "Jnhzi7");
            
//    	    comando =
//    	            new MeuPreparedStatement (
//    	            "com.microsoft.sqlserver.jdbc.SQLServerDriver",
//    	            "jdbc:sqlserver://localhost:1433;databasename=poo201845",
//    	            "sa", "12345ppP_");

            usuarios = new UsuarioDAO ();
        }
        catch (Exception erro)
        {
            System.err.println ("Problemas de conexao com o BD.");
            System.exit(0); 
        }
        
        COMANDO = comando;
        USUARIOS  = usuarios; 
    }
}