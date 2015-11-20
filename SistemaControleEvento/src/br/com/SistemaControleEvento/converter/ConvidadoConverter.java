package br.com.SistemaControleEvento.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.SistemaControleEvento.sistema.control.DAO.ConvidadoDAO;
import br.com.SistemaControleEvento.sistema.model.Convidado;

@FacesConverter("convidadoConverter")
public class ConvidadoConverter implements Converter {
	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent component, String valor) {
		try {
			Long codigo = Long.parseLong(valor);
			ConvidadoDAO dao = new ConvidadoDAO();
			Convidado convidado = dao.buscarCodigo(codigo);
			return convidado;
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
			Convidado convidado = (Convidado)objeto;
			Long codigo = convidado.getCodConvidado();
			return codigo.toString();
		} catch (RuntimeException e) {
			return null;
		}
	}
}
