package br.com.SistemaControleEvento.sistema.control;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.SistemaControleEvento.sistema.control.DAO.EventoDAO;
import br.com.SistemaControleEvento.sistema.model.Cliente;
import br.com.SistemaControleEvento.sistema.model.Evento;
import br.com.SistemaControleEvento.sistema.model.Produto;
import br.com.SistemaControleEvento.sistema.model.SalaoFesta;
import br.com.SistemaControleEvento.util.FacesUtil;

@ManagedBean
@ViewScoped
public class EventoBean {

	private Evento evento;
	
	private List<Evento> listaEventos;
	
	private List<Evento> listaEventoFiltrados;
	
	private List<Produto> comboProdutos;
	
	private List<Cliente> comboClientes;
	
	private List<SalaoFesta> comboSaloes;
	
	public Evento getEvento() {
		return evento;
	}
	
	public void setEvento(Evento evento) {
		this.evento = evento;
	}
	
	public List<Evento> getListaEventos() {
		return listaEventos;
	}
	
	public void setListaEventos(List<Evento> listaEventos) {
		this.listaEventos = listaEventos;
	}
	
	public List<Evento> getListaEventoFiltrados() {
		return listaEventoFiltrados;
	}
	
	public void setListaEventoFiltrados(List<Evento> listaEventoFiltrados) {
		this.listaEventoFiltrados = listaEventoFiltrados;
	}
	
	public List<Produto> getComboProdutos() {
		return comboProdutos;
	}
	
	public void setComboProdutos(List<Produto> comboProdutos) {
		this.comboProdutos = comboProdutos;
	}
	
	public List<Cliente> getComboClientes() {
		return comboClientes;
	}
	
	public void setComboClientes(List<Cliente> comboClientes) {
		this.comboClientes = comboClientes;
	}
	
	public List<SalaoFesta> getComboSaloes() {
		return comboSaloes;
	}
	
	public void setComboSaloes(List<SalaoFesta> comboSaloes) {
		this.comboSaloes = comboSaloes;
	}
	
	public void novo(){
		evento = new Evento();
	}
	
	public void listar(){
		try{
			EventoDAO dao = new EventoDAO();
			listaEventos = dao.listar();
			
		}catch(RuntimeException e){
			e.printStackTrace();
			FacesUtil.addMsgError("Erro ao listar os eventos");
		}
	}
	
	public void salvar(){
	
		try{
			EventoDAO dao = new EventoDAO();
			dao.salvar(evento);
			FacesUtil.addMsgInfo("Evento cadastrado com sucesso");
			novo();
			listar();
			
		}catch(RuntimeException e){
			e.printStackTrace();
			FacesUtil.addMsgError("Erro ao cadastrar o evento");
		}
	}
	
	public void editar(){
		
		try{
			EventoDAO dao = new EventoDAO();
			dao.editar(evento);
			FacesUtil.addMsgInfo("Evento atualizado com sucesso");
			novo();
			listar();
			
		}catch(RuntimeException e){
			e.printStackTrace();
			FacesUtil.addMsgError("Erro ao atualizar o evento");
		}
	}
	
	public void excluir(){
		
		try{
			EventoDAO dao = new EventoDAO();
			dao.excluir(evento);
			FacesUtil.addMsgInfo("Evento excluído com sucesso");
			novo();
			listar();
			
		}catch(RuntimeException e){
			e.printStackTrace();
			FacesUtil.addMsgError("Erro ao excluir o evento");
		}
	}
	
	
}
