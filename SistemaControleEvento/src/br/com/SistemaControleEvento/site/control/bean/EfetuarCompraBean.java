package br.com.SistemaControleEvento.site.control.bean;

import java.math.BigDecimal;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import br.com.SistemaControleEvento.sistema.control.DAO.EventoDAO;
import br.com.SistemaControleEvento.sistema.model.Cliente;
import br.com.SistemaControleEvento.sistema.model.Combo;
import br.com.SistemaControleEvento.sistema.model.Evento;
import br.com.uol.pagseguro.domain.checkout.Checkout;
import br.com.uol.pagseguro.enums.Currency;
import br.com.uol.pagseguro.enums.DocumentType;
import br.com.uol.pagseguro.enums.ShippingType;
import br.com.uol.pagseguro.exception.PagSeguroServiceException;
import br.com.uol.pagseguro.properties.PagSeguroConfig;

@ManagedBean
@SessionScoped
public class EfetuarCompraBean {
	private Evento evento = new Evento();

	@PostConstruct
	public void iniciar() {
		HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
				.getRequest();
		HttpSession sessao = req.getSession();

		Combo combo = (Combo) sessao.getAttribute("combo");
		Cliente cliente = (Cliente) sessao.getAttribute("cliente");

		this.evento.setCliente(cliente);
		this.evento.setCombo(combo);

	}
	public void Comprar(){
		EventoDAO dao=new EventoDAO();
		
		dao.salvar(evento);
	}
	public void efetuarPagamento() {
		Checkout chk = new Checkout();
		chk.addItem(this.evento.getCombo().getCodCombo().toString(), this.evento.getCombo().getNomeCombo(), 1,
				this.evento.getCombo().getPreco(),new Long(0), new BigDecimal(0));
		chk.setShippingAddress("BRA", this.evento.getCliente().getUf(), this.evento.getCliente().getCidade(),
				this.evento.getCliente().getBairro(), this.evento.getCliente().getCep().toString(),
				this.evento.getCliente().getLogadouro(), this.evento.getCliente().getNumero().toString(),
				this.evento.getCliente().getComplemento());
		chk.setShippingType(ShippingType.SEDEX);
		String celular=this.evento.getCliente().getCelular().toString();
		
		chk.setSender(this.evento.getCliente().getNome() + " " + this.evento.getCliente().getSobrenome(),
				this.evento.getCliente().getEmail(),celular.substring(0, 2), celular.substring(3, 11), DocumentType.CPF, this.evento.getCliente().getCpf());
		chk.setCurrency(Currency.BRL);
		chk.setReference("Ref01");
		chk.setRedirectURL(((HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest()).getContextPath()+"/site/restrito/finalizou.xhtml");
		
		try {
			String resposta=chk.register(PagSeguroConfig.getAccountCredentials(),false);
			System.out.println(resposta);
		} catch (PagSeguroServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}
}
