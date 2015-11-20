package br.com.SistemaControleEvento.sistema.control.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.SistemaControleEvento.sistema.model.SalaoFesta;
import br.com.SistemaControleEvento.util.HibernateUtil;

public class SalaoFestaDAO {
	public void salvar(SalaoFesta salao) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.save(salao);
			transaction.commit();

		} catch (Exception ex) {
			if (transaction != null)
				transaction.rollback();
		} finally {
			session.close();
		}
	}

	public void editar(SalaoFesta salao) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			session.update(salao);
			transaction.commit();

		} catch (Exception ex) {
			if (transaction != null)
				transaction.rollback();
		} finally {
			session.close();
		}
	}

	public void excluir(SalaoFesta salao) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			session.delete(salao);
			transaction.commit();

		} catch (Exception ex) {
			if (transaction != null)
				transaction.rollback();
		} finally {
			session.close();
		}
	}

	public SalaoFesta buscarCodigo(Long codigo) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		SalaoFesta salao = null;

		try {
			Query consulta = session.getNamedQuery("SalaoFesta.buscarCodigo");
			consulta.setLong("codSalao", codigo);
			salao = (SalaoFesta) consulta.uniqueResult();

		} catch (RuntimeException ex) {
			throw ex;
		} finally {
			session.close();
		}

		return salao;
	}

	@SuppressWarnings("unchecked")
	public List<SalaoFesta> listar(){
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<SalaoFesta> saloes = null;
				
		try{
			Query consulta = session.getNamedQuery("SalaoFesta.listar");
			saloes = consulta.list();
					
		}catch(RuntimeException ex){
			throw ex;
		}finally{
			session.close();
		}
				
		return saloes;
				
	}
}
