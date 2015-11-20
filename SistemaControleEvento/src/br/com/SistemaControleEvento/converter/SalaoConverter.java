package br.com.SistemaControleEvento.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.SistemaControleEvento.sistema.control.DAO.SalaoFestaDAO;
import br.com.SistemaControleEvento.sistema.model.SalaoFesta;

@FacesConverter("salaoConverter")
public class SalaoConverter implements Converter {

	public Object getAsObject(FacesContext facesContext, UIComponent component, String valor) {
		try {
			Long codigo = Long.parseLong(valor);
			SalaoFestaDAO dao = new SalaoFestaDAO();
			SalaoFesta salao = dao.buscarCodigo(codigo);
			return salao;
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
			SalaoFesta produto = (SalaoFesta)objeto;
			Long codigo = produto.getCodSalao();
			return codigo.toString();
		} catch (RuntimeException e) {
			return null;
		}
	}
}
