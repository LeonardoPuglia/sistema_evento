package br.com.SistemaControleEvento.Test;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.SistemaControleEvento.sistema.control.DAO.FornecedorDAO;
import br.com.SistemaControleEvento.sistema.control.DAO.ProdutoDAO;
import br.com.SistemaControleEvento.sistema.model.Fornecedor;
import br.com.SistemaControleEvento.sistema.model.Produto;

public class ProdutoTeste {

	@Test
	@Ignore
	public void salvar(){
		
		Produto p = new Produto();
		
		Fornecedor f = new Fornecedor();
		FornecedorDAO Fdao = new FornecedorDAO();
		ProdutoDAO dao = new ProdutoDAO();
		System.out.println("antes busca");
		f = Fdao.buscarCodigo(1L);
		System.out.println("pos busca");
		
		p.setCarenciaDias(5);
		p.setDescricao("Mesa Redonda");
		p.setFornecedor(f);
		p.setNome("Mesa Ajax");
		p.setUnidadeMedida("Metros");
		p.setValor(new BigDecimal(66.9));
		
		dao.salvar(p);
		
	}
	
	@Test
	public void listar(){
		ProdutoDAO dao = new ProdutoDAO();
		List<Produto> lista = dao.listar();
		
		for(Produto p: lista){
			System.out.println(p);
		}
	}
}
