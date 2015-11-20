package br.com.SistemaControleEvento.sistema.control.DAO;

import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.SistemaControleEvento.sistema.model.Produto;
import br.com.SistemaControleEvento.util.HibernateUtil;

public class ProdutoDAO {

	public void salvar(Produto produto) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			session.save(produto);
			transaction.commit();

		} catch (RuntimeException e) {
			if (transaction != null)
				transaction.rollback();
		} finally {
			session.close();
		}
	}

	public void editar(Produto produto) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			session.update(produto);
			transaction.commit();

		} catch (RuntimeException e) {
			if (transaction != null)
				transaction.rollback();
		} finally {
			session.close();
		}
	}

	public void excluir(Produto produto) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			session.delete(produto);
			transaction.commit();

		} catch (RuntimeException e) {
			if (transaction != null)
				transaction.rollback();
		} finally {
			session.close();
		}
	}

	public Produto buscarCodigo(Long codigo) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Produto produto = null;

		try {
			Query consulta = session.getNamedQuery("Produto.buscarCodigo");
			consulta.setLong("id_produto", codigo);
			produto = (Produto) consulta.uniqueResult();

		} catch (RuntimeException ex) {
			throw ex;
		} finally {
			session.close();
		}

		return produto;
	}

	@SuppressWarnings("unchecked")
	public ArrayList<Produto> listar(){
		Session session = HibernateUtil.getSessionFactory().openSession();
		ArrayList<Produto> produtos = null;
				
		try{
			Query consulta = session.getNamedQuery("Produto.listar");
			produtos = (ArrayList<Produto>) consulta.list();
					
		}catch(RuntimeException ex){
			throw ex;
		}finally{
			session.close();
		}
				
		return produtos;
	}
}
