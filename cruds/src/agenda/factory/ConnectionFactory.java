package agenda.factory;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

	// Nome do usuário do mysql
	private static final String USERNAME = "root";

	// Senha do banco
	private static final String PASSWORD = "root";

	/* Caminho do banco de dados, porta, nome do banco de dados... minha conexão é
	* do tipo JDBC
	*vc PRECISA usar SSL na conexão com o banco? Se vc não precisa, então vc pode fazer, por exemplo
	*nome do seu banco + --> "useTimezone=true&serverTimezone=UTC&useSSL=false"
	*/


	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/agenda?"
			+ "useTimezone=true&serverTimezone=UTC&useSSL=false";

	/*
	 * Conexão com o banco de dados
	 */

	public static Connection createConnectionMySQL() throws Exception {
		// Faz com que a classe seja carregada pela JVM
		Class.forName("com.mysql.jdbc.Driver");

		// Criando conexão com o banco de dados
		Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);

		return connection;
	}

	public static void main(String[] args) throws Exception {
		
		// Recuperando a conexão com o banco de dados
		Connection con = createConnectionMySQL();

		// Testando se minha conexão é nula

		if (con != null) {
			System.out.println("Conectado com sucesso!!");
			con.close();
		}

	}

}
