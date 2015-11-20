package br.com.SistemaControleEvento.site.control.bean;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.SistemaControleEvento.sistema.control.DAO.ClienteDAO;
import br.com.SistemaControleEvento.sistema.model.Cliente;
import br.com.SistemaControleEvento.util.FacesUtil;

@ManagedBean
@SessionScoped
public class LoginBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String email;
	private String senha;
	private Cliente cliente;
	private ClienteDAO dao=new ClienteDAO();


		
	public boolean getUsuarioLogado(){
		return cliente!=null;
	}
	
	public String sair() throws IOException{
		cliente=null;

		HttpServletRequest req=(HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		
		HttpSession sessao=((HttpServletRequest)req).getSession(true);
		
		sessao.invalidate();
		return "/site/inicial";
	}
	
	public String buscarUsuario(){
		Cliente cliente=dao.buscarEmailSenha(this.email, this.senha);
		
		HttpServletRequest req=(HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		HttpSession sessao=((HttpServletRequest)req).getSession(true);
				
		if(cliente!=null){
			this.cliente=cliente;
			
			FacesUtil.addMsgInfo("Seja bem vindo "+cliente.getNome()+" ao Mundo em Festa");		
			
			sessao.setAttribute("cliente", cliente);
			
			
			return "restrito/meuEspaco.xhtml?faces-redirect=true";
		}else{
			FacesUtil.addMsgError("Usuário ou senha incorretos! Tente novamente.");
			return null;
		}
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}
