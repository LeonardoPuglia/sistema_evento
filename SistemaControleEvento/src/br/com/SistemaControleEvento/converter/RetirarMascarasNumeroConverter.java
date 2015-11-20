package br.com.SistemaControleEvento.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value="retirarMascarasNumero")
public class RetirarMascarasNumeroConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String valor) {
		// TODO Auto-generated method stub
		if(valor!=null && !valor.equals("")){
			valor=valor.replaceAll("[-/.]", "");
			valor=valor.replaceAll("[-()]", "");
			valor=valor.replaceAll("[ ]", "");
		}
		if(valor.equals("")){
			return 0;
		}
		return Long.parseLong(valor);
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object valor) {
		// TODO Auto-generated method stub
		return valor.toString();
	}

}
