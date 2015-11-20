package br.com.SistemaControleEvento.sistema.control;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.SistemaControleEvento.sistema.control.DAO.FornecedorDAO;
import br.com.SistemaControleEvento.sistema.control.DAO.ProdutoDAO;
import br.com.SistemaControleEvento.sistema.model.Fornecedor;
import br.com.SistemaControleEvento.sistema.model.Produto;
import br.com.SistemaControleEvento.util.FacesUtil;

@ManagedBean
@ViewScoped

public class ProdutoBean {

	private Produto produto;
	
	private List<Produto> listaProdutos;
	
	private List<Produto> listaFiltrados;
	
	private List<Fornecedor> comboFornecedores;
	
	public Produto getProduto() {
		return produto;
	}
	
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	public List<Produto> getListaProdutos() {
		return listaProdutos;
	}
	
	public void setListaProdutos(List<Produto> listaProdutos) {
		this.listaProdutos = listaProdutos;
	}
	
	public List<Produto> getListaFiltrados() {
		return listaFiltrados;
	}
	
	public void setListaFiltrados(List<Produto> listaFiltrados) {
		this.listaFiltrados = listaFiltrados;
	}
	
	public List<Fornecedor> getComboFornecedores() {
		return comboFornecedores;
	}
	
	public void setComboFornecedores(List<Fornecedor> comboFornecedores) {
		this.comboFornecedores = comboFornecedores;
	}
	
	public void novo(){
		
		try{
			produto = new Produto();
			
			carregarCadastro();
			
		}catch(RuntimeException e){
			e.printStackTrace();
			FacesUtil.addMsgError("Erro ao listar os fornecedores");
		}
	}
	
	public void carregarCadastro(){
		
		try{
			
			
			FornecedorDAO dao = new FornecedorDAO();
			comboFornecedores = dao.listar();
		}catch(RuntimeException e){
			e.printStackTrace();
			FacesUtil.addMsgError("Erro ao listar os fornecedores");
		}
	}
	
	public void salvar(){
		try{
			ProdutoDAO dao = new ProdutoDAO();
			dao.salvar(produto);
			FacesUtil.addMsgInfo("Produto cadastrado com sucesso");
			novo();
		}catch(RuntimeException ex){
			ex.printStackTrace();
			FacesUtil.addMsgError("Erro ao cadastrar o produto");
		}
	}
	
	public void editar(){
		try{
			ProdutoDAO dao = new ProdutoDAO();
			dao.editar(produto);
			FacesUtil.addMsgInfo("Produto editado com sucesso");
			novo();
		}catch(RuntimeException ex){
			ex.printStackTrace();
			FacesUtil.addMsgError("Erro ao editar o produto");
		}
	}
	
	public void excluir(){
		try{
			ProdutoDAO dao = new ProdutoDAO();
			dao.excluir(produto);
			FacesUtil.addMsgInfo("Produto excluído com sucesso");
			novo();
		}catch(RuntimeException ex){
			ex.printStackTrace();
			FacesUtil.addMsgError("Erro ao excluir o produto");
		}
	}
	
	public void listar(){
		try{
			ProdutoDAO dao = new ProdutoDAO();
			listaProdutos = dao.listar();
			
						
		}catch(RuntimeException ex){
			ex.printStackTrace();
			FacesUtil.addMsgError("Erro ao listar os produtos");
		}
	}
	
	
	
	
}
