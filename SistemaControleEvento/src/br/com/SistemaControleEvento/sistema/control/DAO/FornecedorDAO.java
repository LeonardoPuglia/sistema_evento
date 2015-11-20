package br.com.SistemaControleEvento.sistema.control.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.SistemaControleEvento.sistema.model.Fornecedor;
import br.com.SistemaControleEvento.util.HibernateUtil;

public class FornecedorDAO {

	public void salvar(Fornecedor fornecedor) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.save(fornecedor);
			transaction.commit();

		} catch (Exception ex) {
			if (transaction != null)
				transaction.rollback();
		} finally {
			session.close();
		}
	}

	public void editar(Fornecedor fornecedor) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			session.update(fornecedor);
			transaction.commit();

		} catch (Exception ex) {
			if (transaction != null)
				transaction.rollback();
		} finally {
			session.close();
		}
	}

	public void excluir(Fornecedor fornecedor) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			session.delete(fornecedor);
			transaction.commit();

		} catch (Exception ex) {
			if (transaction != null)
				transaction.rollback();
		} finally {
			session.close();
		}
	}

	public Fornecedor buscarCodigo(Long codigo) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Fornecedor fornecedor = null;

		try {
			Query consulta = session.getNamedQuery("Fornecedor.buscarCodigo");
			consulta.setLong("codFornecedor", codigo);
			fornecedor = (Fornecedor) consulta.uniqueResult();

		} catch (RuntimeException ex) {
			throw ex;
		} finally {
			session.close();
		}

		return fornecedor;
	}

	@SuppressWarnings("unchecked")
	public List<Fornecedor> listar(){
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Fornecedor> fornecedores = null;
				
		try{
			Query consulta = session.getNamedQuery("Fornecedor.listar");
			fornecedores = consulta.list();
					
		}catch(RuntimeException ex){
			throw ex;
		}finally{
			session.close();
		}
				
		return fornecedores;
				
	}

}
