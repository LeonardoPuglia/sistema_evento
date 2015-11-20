package br.com.SistemaControleEvento.site.control.filtro;

import java.io.IOException;

import javax.faces.context.FacesContext;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.SistemaControleEvento.sistema.model.Cliente;
import br.com.SistemaControleEvento.sistema.model.Combo;

@WebFilter("*.xhtml")
public class LoginFiltro implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest requisicao = (HttpServletRequest) req;
		HttpServletResponse resposta = (HttpServletResponse) resp;

		HttpSession sessao = ((HttpServletRequest) req).getSession(true);

		Cliente cliente = (Cliente) sessao.getAttribute("cliente");
		Combo combo = (Combo) sessao.getAttribute("combo");

		if (cliente == null && requisicao.getRequestURI().contains("/site/restrito/")) {
			resposta.sendRedirect(requisicao.getContextPath() + "/site/login.xhtml");
		} else if ((cliente == null || combo == null) && requisicao.getRequestURI().endsWith("finalizarCompra.xhtml")) {
			resposta.sendRedirect(requisicao.getContextPath() + "/site/login.xhtml");
		} else if(combo==null && requisicao.getRequestURI().endsWith("comboDetalhes.xhtml")){
			resposta.sendRedirect(requisicao.getContextPath() + "/site/buscarCombo.xhtml");
		}else{
			chain.doFilter(req, resp);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
