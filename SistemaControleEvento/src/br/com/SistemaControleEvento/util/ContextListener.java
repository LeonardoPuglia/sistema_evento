package br.com.SistemaControleEvento.util;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;



public class ContextListener implements ServletContextListener {

	/*
	 * Chamado quando voc� para	 o tomcat
	 */
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		//Est� fechando uma f�brica de sess�o
		HibernateUtil.getSessionFactory().close();
		
	}

	/*
	 * Chamado quando voc� inicia o tomcat
	 */
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		//Est� pedindo uma f�brica de sess�o
		HibernateUtil.getSessionFactory().openSession();
		
	}

}
