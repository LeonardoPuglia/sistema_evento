package br.com.SistemaControleEvento.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.SistemaControleEvento.sistema.control.DAO.FornecedorDAO;
import br.com.SistemaControleEvento.sistema.model.Fornecedor;

@FacesConverter("fornecedorConverter")
public class FornecedorConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent component, String valor) {
		try {
			Long codigo = Long.parseLong(valor);
			FornecedorDAO dao = new FornecedorDAO();
			Fornecedor fornecedor = dao.buscarCodigo(codigo);
			return fornecedor;
		} catch (RuntimeException e) {
			return null;
		}
	}

	@Override
	public String getAsString(FacesContext facesContext, UIComponent component, Object objeto) {
		try {
			Fornecedor fornecedor = (Fornecedor)objeto;
			Long codigo = fornecedor.getCodFornecedor();
			return codigo.toString();
		} catch (RuntimeException e) {
			return null;
		}
	}

}
