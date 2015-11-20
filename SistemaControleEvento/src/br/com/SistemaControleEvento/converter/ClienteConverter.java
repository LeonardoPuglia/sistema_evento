package br.com.SistemaControleEvento.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.SistemaControleEvento.sistema.control.DAO.ClienteDAO;
import br.com.SistemaControleEvento.sistema.model.Cliente;

@FacesConverter("clienteConverter")
public class ClienteConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent component, String valor) {
		try {
			Long codigo = Long.parseLong(valor);
			ClienteDAO dao = new ClienteDAO();
			Cliente cliente = dao.buscarCodigo(codigo);
			return cliente;
		} catch (RuntimeException e) {
			return null;
		}
	}

	
	/*Montar o combo
	 * recebe um objeto e retorna o seu cod(chave Primaria) 
	 */
	@Override
	public String getAsString(FacesContext facesContext, UIComponent component, Object objeto) {
		try {
			Cliente cliente = (Cliente)objeto;
			Long codigo = cliente.getCodCliente();
			return codigo.toString();
		} catch (RuntimeException e) {
			return null;
		}
	}
}
