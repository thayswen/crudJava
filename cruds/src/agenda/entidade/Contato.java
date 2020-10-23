package agenda.entidade;

import java.util.Date;

public class Contato {

	private int id_contatos;
	private String nome;
	private int idade;
	private Date dataCadastro;
	
	
	public int getId_contatos() {
		return id_contatos;
	}
	
	public void setId_contatos(int id_contatos) {
		this.id_contatos = id_contatos;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
	this.nome = nome;
	}
	
	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	

	}


