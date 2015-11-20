package br.com.SistemaControleEvento.sistema.control.DAO;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import br.com.SistemaControleEvento.sistema.model.Cliente;
import br.com.SistemaControleEvento.util.FacesUtil;
import br.com.SistemaControleEvento.util.HibernateUtil;

public class ClienteDAO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void salvar(Cliente cliente){
		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction t = null;
		
		try{
			String senha=FacesUtil.converterMD5(cliente.getSenha());//criptografa a senha do cliente
			cliente.setSenha(senha);
			t = s.beginTransaction();
			s.save(cliente);
			t.commit();
			//FacesUtil.addMsgInfo("Cadastro efetuado com sucesso!");
		}catch(Exception e){
			if(t != null){
				t.rollback();
			}
			System.out.println("Erro: "+ e);
			//FacesUtil.addMsgError("Não foi possível fazer o cadastro.");
		}finally{
			s.close();
		}
	}
	
	public void editar(Cliente cliente){
		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction t = null;
		
		try{
			cliente.setSenha(FacesUtil.converterMD5(cliente.getSenha()));
			t = s.beginTransaction();
			s.update(cliente);
			t.commit();
			//FacesUtil.addMsgInfo("Cadastro atualizado com sucesso!");
		}catch(Exception e){
			if(t != null)
				t.rollback();
			//FacesUtil.addMsgError("Não foi possível atualizar seu cadastro.");
		}finally{
			s.close();
		}
	}
	
	public void excluir(Cliente cliente){
		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction t = null;
		
		try{
			t = s.beginTransaction();
			s.delete(cliente);
			t.commit();
		}catch(Exception e){
			if(t != null)
				t.rollback();
		}finally{
			s.close();
		}
	}
	
	public Cliente buscarCodigo(Long codigo){
		
		Session s = HibernateUtil.getSessionFactory().openSession();
		Cliente cliente = null;
			
		try{
			Query c = s.getNamedQuery("Cliente.buscarCodigo");	
			c.setLong("codCliente", codigo);
			cliente = (Cliente)c.uniqueResult();
			
		}catch(RuntimeException e){
			throw e;
		}finally{
			s.close();
		}
		return cliente;
	}
	
	public Cliente buscarEmailSenha(String email, String senha){
		Cliente cliente;
		Session sessao=HibernateUtil.getSessionFactory().openSession();
		
		Criteria crit=sessao.createCriteria(Cliente.class);
		
		String senhaCrip=FacesUtil.converterMD5(senha);
		
		crit.add(Restrictions.eq("email", email));
		crit.add(Restrictions.eq("senha", senhaCrip));
		crit.setMaxResults(1);
		cliente= (Cliente) crit.uniqueResult();
		
		if(cliente!=null){
			sessao.close();
			return cliente;
		}else{
			sessao.close();
			return null;
		}
		
	}
	
	public Cliente validaEmailCPF(String email,String cpf){
		Cliente cliente;
		Session sessao=HibernateUtil.getSessionFactory().openSession();
		Criteria crit=sessao.createCriteria(Cliente.class);
		crit.add(Restrictions.or(Restrictions.eq("email",email),Restrictions.eq("cpf",cpf)));
		crit.setMaxResults(1);
		
		cliente=(Cliente) crit.uniqueResult();
		
		if(cliente!=null){
			sessao.close();
			
			return cliente;
		}else{
			sessao.close();
			return null;
		}
	}
		
		@SuppressWarnings("unchecked")
		public List<Cliente> listar(){
			
			Session s = HibernateUtil.getSessionFactory().openSession();
			List<Cliente> clientes = null;
				
			try{
				Query c = s.getNamedQuery("Cliente.listar");	
				clientes = c.list();
				
			}catch(RuntimeException e){
				throw e;
			}finally{
				s.close();
			}
		return clientes;
	}
	
	
	
	
}
