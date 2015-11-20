	package br.com.SistemaControleEvento.sistema.control;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.SistemaControleEvento.sistema.control.DAO.FornecedorDAO;
import br.com.SistemaControleEvento.sistema.model.Fornecedor;
import br.com.SistemaControleEvento.util.FacesUtil;

@ManagedBean
@ViewScoped

public class FornecedorBean {

	
	private Fornecedor fornecedor;
	
	private List<Fornecedor> listaFornecedores;
	
	private List<Fornecedor> listaFornecedoresFiltrados;
	

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public List<Fornecedor> getListaFornecedores() {
		return listaFornecedores;
	}

	public void setListaFornecedores(List<Fornecedor> listaFornecedores) {
		this.listaFornecedores = listaFornecedores;
	}

	public List<Fornecedor> getListaFornecedoresFiltrados() {
		return listaFornecedoresFiltrados;
	}

	public void setListaFornecedoresFiltrados(List<Fornecedor> listaFornecedoresFiltrados) {
		this.listaFornecedoresFiltrados = listaFornecedoresFiltrados;
	}

	
	
	public void novo(){
		fornecedor = new Fornecedor();
	}
	
	public void salvar(){
		try{
			FornecedorDAO dao = new FornecedorDAO();
			dao.salvar(fornecedor);
			FacesUtil.addMsgInfo("Fornecedor cadastrado com Sucesso");
			novo();
			listar();
			
		}catch(RuntimeException e){
			e.printStackTrace();
			FacesUtil.addMsgInfo("Erro ao tentar cadastrar novo fornecedor");
		}
	}
	
	public void listar(){
		try{
			FornecedorDAO dao = new FornecedorDAO();
			listaFornecedores  = dao.listar();
			
		}catch(RuntimeException e){
			e.printStackTrace();
			FacesUtil.addMsgInfo("Erro ao tentar listar os fornecedor");
		}
		
	}
	
	
	public void excluir(){
		try{
			FornecedorDAO dao = new FornecedorDAO();
			dao.excluir(fornecedor);
			FacesUtil.addMsgInfo("Fornecedor excluido com sucesso");
			novo();
			listar();
			
		}catch(RuntimeException e){
			e.printStackTrace();
			FacesUtil.addMsgError("Erro ao tentar excluir o fornecedor");
		}
	}
	
	public void editar(){
		try{
			FornecedorDAO dao = new FornecedorDAO();
			dao.editar(fornecedor);
			FacesUtil.addMsgInfo("Fornecedor atualizado com sucesso");
			novo();
			listar();
			
		}catch(RuntimeException e){
			e.printStackTrace();
			FacesUtil.addMsgError("Erro ao tentar atualizar o fornecedor");
		}
	}
}
