package br.com.SistemaControleEvento.sistema.control;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.SistemaControleEvento.sistema.control.DAO.ConvidadoDAO;
import br.com.SistemaControleEvento.sistema.model.Convidado;
import br.com.SistemaControleEvento.util.FacesUtil;

@ManagedBean
@ViewScoped
public class ConvidadoBean {

	private Convidado convidado;
	
	private List<Convidado> listaConvidados;
	
	private List<Convidado> listaConvidadoFiltrados;
	
	public Convidado getConvidado() {
		return convidado;
	}
	
	public void setConvidado(Convidado convidado) {
		this.convidado = convidado;
	}
	
	public List<Convidado> getListaConvidadoFiltrados() {
		return listaConvidadoFiltrados;
	}
	
	public void setListaConvidadoFiltrados(List<Convidado> listaConvidadoFiltrados) {
		this.listaConvidadoFiltrados = listaConvidadoFiltrados;
	}
	
	public List<Convidado> getListaConvidados() {
		return listaConvidados;
	}
	
	public void setListaConvidados(List<Convidado> listaConvidados) {
		this.listaConvidados = listaConvidados;
	}
	
	public void novo(){
		convidado = new Convidado();
	}
	
	public void listar(){
		try{
			ConvidadoDAO dao = new ConvidadoDAO();
			listaConvidados = dao.listar();
			
		}catch(RuntimeException e){
			e.printStackTrace();
			FacesUtil.addMsgError("Erro ao listar os convidados");
		}
	}
	
	public void salvar(){
		try{
			ConvidadoDAO dao = new ConvidadoDAO();
			dao.salvar(convidado);
			FacesUtil.addMsgInfo("Convidado cadastrado com sucesso");
			novo();
			listar();
			
		}catch(RuntimeException e){
			e.printStackTrace();
			FacesUtil.addMsgError("Erro ao salvar o convidado");
		}
	}
	
	public void editar(){
		try{
			ConvidadoDAO dao = new ConvidadoDAO();
			dao.editar(convidado);
			FacesUtil.addMsgInfo("Convidado atualizado com sucesso");
			novo();
			listar();
			
		}catch(RuntimeException e){
			e.printStackTrace();
			FacesUtil.addMsgError("Erro ao atualizar o convidado");
		}
	}
	
	public void excluir(){
		try{
			ConvidadoDAO dao = new ConvidadoDAO();
			dao.excluir(convidado);
			FacesUtil.addMsgInfo("Convidado excluído com sucesso");
			novo();
			listar();
			
		}catch(RuntimeException e){
			e.printStackTrace();
			FacesUtil.addMsgError("Erro ao excluir o convidado");
		}
	}
}
