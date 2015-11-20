package br.com.SistemaControleEvento.sistema.control.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.SistemaControleEvento.sistema.model.Evento;
import br.com.SistemaControleEvento.util.HibernateUtil;

public class EventoDAO {

	public void salvar(Evento evento){
		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction t = null;
		
		try{
			t = s.beginTransaction();
			s.save(evento);
			t.commit();
			
		}catch(Exception e){
			if(t != null)
				t.rollback();
		}finally{
			s.close();
		}
	}
	
	public void editar(Evento evento){
		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction t = null;
		
		try{
			t = s.beginTransaction();
			s.update(evento);
			t.commit();
			
		}catch(Exception e){
			if(t != null)
				t.rollback();
		}finally{
			s.close();
		}
	}
	
	public void excluir(Evento evento){
		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction t = null;
		
		try{
			t = s.beginTransaction();
			s.delete(evento);
			t.commit();
			
		}catch(Exception e){
			if(t != null)
				t.rollback();
		}finally{
			s.close();
		}
	}
	
	public Evento buscarCodigo(Long codigo){
		Session s = HibernateUtil.getSessionFactory().openSession();
		Evento evento = null;
		
		try{
			Query c = s.getNamedQuery("Evento.buscarCodigo");
			c.setLong("codEvento", codigo);
			evento = (Evento)c.uniqueResult();
			
		}catch(RuntimeException e){
				throw e;
		}finally{
			s.close();
		}
		return evento;
	}
	
	@SuppressWarnings("unchecked")
	public List<Evento> listar(){
		Session s = HibernateUtil.getSessionFactory().openSession();
		List<Evento> eventos = null;
		
		try{
			Query c = s.getNamedQuery("Evento.listar");
			eventos = c.list();
			
		}catch(RuntimeException e){
				throw e;
		}finally{
			s.close();
		}
		return eventos;
	}
}
