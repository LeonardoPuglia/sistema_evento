package br.com.SistemaControleEvento.sistema.control;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.SistemaControleEvento.sistema.control.DAO.ClienteDAO;
import br.com.SistemaControleEvento.sistema.model.Cliente;
import br.com.SistemaControleEvento.util.FacesUtil;

@ManagedBean
@ViewScoped
public class ClienteBean {

	private Cliente cliente;
	
	private List<Cliente> listaClientes;
	
	private List<Cliente> listaClientesFiltrados;
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public List<Cliente> getListaClientes() {
		return listaClientes;
	}
	
	public void setListaClientes(List<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}
	
	public List<Cliente> getListaClientesFiltrados() {
		return listaClientesFiltrados;
	}
	
	public void setListaClientesFiltrados(List<Cliente> listaClientesFiltrados) {
		this.listaClientesFiltrados = listaClientesFiltrados;
	}
	
	public void novo(){
		cliente = new Cliente();
	}
	
	public void listar(){
		try{
			ClienteDAO dao = new ClienteDAO();
			listaClientes = dao.listar();
		}catch(RuntimeException e){
			e.printStackTrace();
			FacesUtil.addMsgError("Erro ao listar os clientes");
		}
	}
	
	public void salvar(){
		try{
			ClienteDAO dao = new ClienteDAO();
			dao.salvar(cliente);
			FacesUtil.addMsgInfo("Cliente cadastrado com sucesso");
			novo();
			listar();
		}catch(RuntimeException e){
			e.printStackTrace();
			FacesUtil.addMsgError("Erro ao cadastrar cliente");
		}
	}
	
	public void editar(){
		try{
			ClienteDAO dao = new ClienteDAO();
			dao.editar(cliente);
			FacesUtil.addMsgInfo("Cliente atualizado com sucesso");
			novo();
			listar();
		}catch(RuntimeException e){
			e.printStackTrace();
			FacesUtil.addMsgError("Erro ao atualizar cliente");
		}
	}
	
	public void excluir(){
		try{
			ClienteDAO dao = new ClienteDAO();
			dao.excluir(cliente);
			FacesUtil.addMsgInfo("Cliente excluído com sucesso");
			novo();
			listar();
		}catch(RuntimeException e){
			e.printStackTrace();
			FacesUtil.addMsgError("Erro ao excluido cliente");
		}
	}
}
