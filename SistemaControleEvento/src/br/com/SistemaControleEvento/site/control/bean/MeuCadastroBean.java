package br.com.SistemaControleEvento.site.control.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.SistemaControleEvento.sistema.control.DAO.ClienteDAO;
import br.com.SistemaControleEvento.sistema.model.Cliente;

@ManagedBean
@SessionScoped
public class MeuCadastroBean {
	private Cliente cliente =new Cliente();
	private ClienteDAO dao=new ClienteDAO();
	
	public void iniciar(){
		
	}
	public void atualizar(){
		dao.editar(cliente);
	}
	
	public String meusEventos(){
		return "meusEventos.xhtml";
	}
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
}
