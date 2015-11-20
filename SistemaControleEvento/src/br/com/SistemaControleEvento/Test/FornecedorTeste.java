package br.com.SistemaControleEvento.Test;

import org.junit.Test;

import br.com.SistemaControleEvento.sistema.control.DAO.FornecedorDAO;
import br.com.SistemaControleEvento.sistema.model.Fornecedor;



public class FornecedorTeste {

	@Test

	public void salvar(){
		Fornecedor f1 = new Fornecedor();
		
		f1.setCnpj("94.854.345/9094-05");
		f1.setNomeFantasia("Olimpics");
		f1.setRazaoSocial("OlimpicsGugu");
		f1.setTelefoneContato("(11)4575-9999");
		f1.setNomeContato("Leonor");
		f1.setEmailContato("leo.opo@hotmail.com");
		f1.setLogadouro("Rua Almirante");
		f1.setNumero(345L);
		f1.setComplemento("Próximo a Padaria Saudade");
		f1.setBairro("Vl Formosa");
		f1.setCidade("Mauá");
		f1.setUf("São Paulo");
		
		System.out.println(f1);
		
		
		FornecedorDAO dao = new FornecedorDAO();
		
		dao.salvar(f1);
		
	}
	
	/*
	@Test
	@Ignore
	public void listar(){
		
		FornecedorDAO dao = new FornecedorDAO();
		
		List<Fornecedor> lista = dao.listar();
		
		
		
	}*/
}
