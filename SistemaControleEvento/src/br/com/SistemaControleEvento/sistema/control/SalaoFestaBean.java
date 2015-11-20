package br.com.SistemaControleEvento.sistema.control;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.SistemaControleEvento.sistema.control.DAO.SalaoFestaDAO;
import br.com.SistemaControleEvento.sistema.model.SalaoFesta;
import br.com.SistemaControleEvento.util.FacesUtil;

@ManagedBean
@ViewScoped

public class SalaoFestaBean {
	private SalaoFesta salao;
	
	private List<SalaoFesta> listaSaloes;
	
	private List<SalaoFesta> listaSaloesFiltrados;
	

	public SalaoFesta getSalao() {
		return salao;
	}

	public void setSalao(SalaoFesta salao) {
		this.salao = salao;
	}

	public List<SalaoFesta> getListaSaloes() {
		return listaSaloes;
	}

	public void setListaSaloes(List<SalaoFesta> listaSaloes) {
		this.listaSaloes = listaSaloes;
	}

	public List<SalaoFesta> getListaSaloesFiltrados() {
		return listaSaloesFiltrados;
	}

	public void setListaSaloesFiltrados(List<SalaoFesta> listaSaloesFiltrados) {
		this.listaSaloesFiltrados = listaSaloesFiltrados;
	}

	
	
	public void novo(){
		salao = new SalaoFesta();
	}
	
	public void salvar(){
		try{
			SalaoFestaDAO dao = new SalaoFestaDAO();
			dao.salvar(salao);
			FacesUtil.addMsgInfo("Salão cadastrado com Sucesso");
			novo();
			listar();
			
		}catch(RuntimeException e){
			e.printStackTrace();
			FacesUtil.addMsgInfo("Erro ao tentar cadastrar novo salão");
		}
	}
	
	public void listar(){
		try{
			SalaoFestaDAO dao = new SalaoFestaDAO();
			listaSaloes  = dao.listar();
			
		}catch(RuntimeException e){
			e.printStackTrace();
			FacesUtil.addMsgInfo("Erro ao tentar listar os salões");
		}
		
	}
	
	
	public void excluir(){
		try{
			SalaoFestaDAO dao = new SalaoFestaDAO();
			dao.excluir(salao);
			FacesUtil.addMsgInfo("Salão excluido com sucesso");
			novo();
			listar();
			
		}catch(RuntimeException e){
			e.printStackTrace();
			FacesUtil.addMsgError("Erro ao tentar excluir o salão");
		}
	}
	
	public void editar(){
		try{
			SalaoFestaDAO dao = new SalaoFestaDAO();
			dao.editar(salao);
			FacesUtil.addMsgInfo("Salão atualizado com sucesso");
			novo();
			listar();
			
		}catch(RuntimeException e){
			e.printStackTrace();
			FacesUtil.addMsgError("Erro ao tentar atualizar o salão");
		}
	}
}
