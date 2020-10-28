package agenda.principal;

import java.util.Date;

import agenda.dao.ContatoDAO;
import agenda.entidade.Contato;

public class ContatoMain {

	public static void main(String[] args) {
		
		ContatoDAO dao = new ContatoDAO();
		Contato contato = new Contato();
		
		contato.setNome("Thay Swen");
		contato.setIdade(15);
		contato.setDataCadastro(new Date());
	
		dao.salvarContato(contato);
		
		//Visualização dos registros do banco de dados
		
		for(Contato c : dao.listarContato()) {
			System.out.println("Contato: " + c.getNome() + " \n "+ c.getIdade() + "\n " + c.getDataCadastro() );
			
		}
		
	}

}
