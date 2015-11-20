package br.com.SistemaControleEvento.sistema.control.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.SistemaControleEvento.sistema.model.Combo;
import br.com.SistemaControleEvento.util.HibernateUtil;

public class ComboDAO {

	public void salvar(Combo combo){
		
		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction t = null;
		
		try{
			t = s.beginTransaction();
			s.save(combo);
			t.commit();
			
		}catch(Exception e){
			if(t != null)
				t.rollback();
		}finally{
			s.close();
		}
	}
	
	public void editar(Combo combo){
		
		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction t = null;
		
		try{
			t = s.beginTransaction();
			s.update(combo);
			t.commit();
			
		}catch(Exception e){
			if(t != null)
				t.rollback();
		}finally{
			s.close();
		}
	}

	public void excluir(Combo combo){
	
		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction t = null;
		
		try{
			t = s.beginTransaction();
			s.delete(combo);
			t.commit();
			
		}catch(Exception e){
			if(t != null)
				t.rollback();
		}finally{
			s.close();
		}
	}
	
	public Combo buscarCodigo(Long codigo){
		Session s = HibernateUtil.getSessionFactory().openSession();
		Combo combo = null;
		
		try{
			Query consulta = s.getNamedQuery("Combo.buscarCodigo");
			consulta.setLong("codCombo", codigo);
			combo = (Combo)consulta.uniqueResult();
			
		}catch(RuntimeException e){
			throw e;
		}finally{
			s.close();
		}
		return combo;
	}
	
	@SuppressWarnings("unchecked")
	public List<Combo> listar(){
		Session s = HibernateUtil.getSessionFactory().openSession();
		List<Combo> lista = null;
		
		try{
			Query consulta = s.getNamedQuery("Combo.listar");
			lista = consulta.list();
			
			
		}catch(RuntimeException e){
			throw e;
		}finally{
			s.close();
		}
		return lista;
	}
}
