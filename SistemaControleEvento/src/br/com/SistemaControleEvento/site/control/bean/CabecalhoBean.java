package br.com.SistemaControleEvento.site.control.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class CabecalhoBean {
	public List<String> buscar(String query){
		List<String> retorno=new ArrayList<String>();
		
		for(int i=0;i<5;i++){
			retorno.add(query+i);
		}
		return retorno;
	}
	public void testar(){
		System.out.println("funcionou!!!!!!!!!!!");
	}
}
