package br.com.SistemaControleEvento.util;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;



public class ContextListener implements ServletContextListener {

	/*
	 * Chamado quando você para	 o tomcat
	 */
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		//Está fechando uma fábrica de sessão
		HibernateUtil.getSessionFactory().close();
		
	}

	/*
	 * Chamado quando você inicia o tomcat
	 */
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		//Está pedindo uma fábrica de sessão
		HibernateUtil.getSessionFactory().openSession();
		
	}

}
