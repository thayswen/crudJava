package agenda.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import agenda.entidade.Contato;
import agenda.factory.ConnectionFactory;

public class ContatoDAO {

	public void salvarContato(Contato contato) {
		String sql = "INSERT INTO contatos(nome, idade, datacadastro) " + "VALUES (? , ?, ?)";

		Connection conn = null;
		PreparedStatement ps = null;

		try {
			// Aqui estou criando minha conexão com banco de dados
			conn = ConnectionFactory.createConnectionMySQL();

			// Para executar um query criei uma PreparedStatement
			ps = (PreparedStatement) conn.prepareStatement(sql);

			// Estout adicionando os valores que são esperados pela query
			ps.setString(1, contato.getNome());
			ps.setInt(2, contato.getIdade());
			ps.setDate(3, new Date(contato.getDataCadastro().getTime()));

			// Executar a query
			ps.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// para fechar as minhas conexões
			try {
				if (ps != null) {
					ps.close();
				}
				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	public List<Contato> listarContato(){
		
		String sql = "SELECT * FROM contatos";
		
		List<Contato> contatos = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement ps = null;
		
		//Classe que vai recuperar os dados do meu banco. Nosso SELECT
		ResultSet rs = null;
		
		try {
			conn = ConnectionFactory.createConnectionMySQL();
			ps = (PreparedStatement) conn.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				Contato contato = new Contato();
				
				//Recuperar o id
				contato.setId_contatos(rs.getInt("id_contatos"));
				
				//Recuperar o nome
				contato.setNome(rs.getString("nome"));
				
				//Recuperar o idade
				contato.setIdade(rs.getInt("idade"));
				
				//Recuperar o data
				contato.setDataCadastro(rs.getDate("dataCadastro"));
				
				contatos.add(contato);
			}
		}catch(Exception e) {
				e.printStackTrace();
			}finally {
				try {
					if(rs!=null) {
						rs.close();
					}if(ps!=null) {
						ps.close();
					}if(conn!=null){
						conn.close();
					}
				}catch(Exception e){
					e.printStackTrace();
				}
			}				
			return contatos;			
		}	
	}
