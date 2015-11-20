package br.com.SistemaControleEvento.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.SistemaControleEvento.sistema.control.DAO.ProdutoDAO;
import br.com.SistemaControleEvento.sistema.model.Produto;

@FacesConverter("produtoConverter")
public class ProdutoConverter implements Converter {

	/*Quando seleciono alguem ele roda o getasObject
	 * Recebe uma chave estrangeira em String e monta o objeto
	 * 
	 */
	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent component, String valor) {
		try {
			Long codigo = Long.parseLong(valor);
			ProdutoDAO dao = new ProdutoDAO();
			Produto produto = dao.buscarCodigo(codigo);
			return produto;
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
			Produto produto = (Produto)objeto;
			Long codigo = produto.getCodProduto();
			return codigo.toString();
		} catch (RuntimeException e) {
			return null;
		}
	}

}
