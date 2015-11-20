package br.com.SistemaControleEvento.site.control.bean;

import java.io.Serializable;
import java.security.MessageDigest;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.hamcrest.core.Is;

import br.com.SistemaControleEvento.sistema.control.DAO.ClienteDAO;
import br.com.SistemaControleEvento.sistema.model.Cliente;
import br.com.SistemaControleEvento.util.FacesUtil;

@ManagedBean
@ViewScoped
public class CadastrarClienteBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Cliente cliente = new Cliente();

	public void cadastrarCliente(ActionEvent evt) {

		try {

			ClienteDAO dao = new ClienteDAO();

			if (dao.validaEmailCPF(cliente.getEmail(), cliente.getCpf()) == null) {
				dao.salvar(cliente);

				cliente = new Cliente();
			}else{
				FacesUtil.addMsgError("Já existe uma pessoa cadastrada com este email ou CPF!");
			}

		} catch (Exception e) {
			FacesUtil.addMsgError("Não foi possível realizar o cadastro.");
		}

	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
}
