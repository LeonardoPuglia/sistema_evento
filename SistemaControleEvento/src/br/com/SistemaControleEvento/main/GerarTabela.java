package br.com.SistemaControleEvento.main;

import br.com.SistemaControleEvento.util.HibernateUtil;

public class GerarTabela {

	public static void main(String[] args) {
		
		HibernateUtil.getSessionFactory();
		
		HibernateUtil.getSessionFactory().close();

	}

}
