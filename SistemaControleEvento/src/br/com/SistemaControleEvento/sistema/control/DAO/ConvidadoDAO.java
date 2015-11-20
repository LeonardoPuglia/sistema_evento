package br.com.SistemaControleEvento.sistema.control.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.SistemaControleEvento.sistema.model.Convidado;
import br.com.SistemaControleEvento.util.HibernateUtil;

public class ConvidadoDAO {

	public void salvar(Convidado convidado){
		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction t = null;
		
		try{
			t = s.beginTransaction();
			s.save(convidado);
			t.commit();
		}catch(Exception e){
			if(t != null)
				t.rollback();
		}finally{
			s.close();
		}
	}
	
	public void editar(Convidado convidado){
		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction t = null;
		
		try{
			t = s.beginTransaction();
			s.update(convidado);
			t.commit();
		}catch(Exception e){
			if(t != null)
				t.rollback();
		}finally{
			s.close();
		}
	}
	
	public void excluir(Convidado convidado){
		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction t = null;
		//apenas pra commitar essa classe de novo
		try{
			t = s.beginTransaction();
			s.delete(convidado);
			t.commit();
		}catch(Exception e){
			if(t != null)
				t.rollback();
		}finally{
			s.close();
		}
	}
	
	public Convidado buscarCodigo(Long codigo){
		Session s = HibernateUtil.getSessionFactory().openSession();
		Convidado convidado = null;
		
		try{
			Query c = s.getNamedQuery("Convidado.buscarCodigo");
			c.setLong("codConvidado", codigo);
			convidado = (Convidado)c.uniqueResult();
		}catch(RuntimeException e){
			throw e;
		}finally{
			s.close();
		}
		return convidado;
	}
	
	@SuppressWarnings("unchecked")
	public List<Convidado> listar(){
		Session s = HibernateUtil.getSessionFactory().openSession();
		List<Convidado> convidados = null;
		
		try{
			Query c = s.getNamedQuery("Convidado.listar");
			convidados = c.list();
		}catch(RuntimeException e){
			throw e;
		}finally{
			s.close();
		}
		return convidados;
	}
}

