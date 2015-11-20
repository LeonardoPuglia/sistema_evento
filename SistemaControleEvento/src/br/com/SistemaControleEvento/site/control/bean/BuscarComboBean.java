package br.com.SistemaControleEvento.site.control.bean;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import br.com.SistemaControleEvento.sistema.control.DAO.ComboDAO;
import br.com.SistemaControleEvento.sistema.model.Combo;
import br.com.SistemaControleEvento.sistema.model.Produto;
import br.com.SistemaControleEvento.site.model.Imagem;

@ManagedBean
@SessionScoped
public class BuscarComboBean {
	private List<Combo> combos = new ArrayList<Combo>();
	private Combo comboSelecionada;

	@PostConstruct
	public void iniciar() {
		ComboDAO dao = new ComboDAO();
		setCombos(dao.listar());
		
		/*
		 * Combo c=new Combo(); Imagem img=new Imagem(); List<Imagem>
		 * imagens=new ArrayList<>(); Produto p=new Produto(); List<Produto>
		 * produtos=new ArrayList<>(); List<Imagem> imagensP = new
		 * ArrayList<>();
		 * 
		 * for(int i=1;i<=20;i++){ c.setCodCombo((long) (i*10)); c.setDescricao(
		 * "Além de prejudicar o posicionamento em buscas orgânicas, publicar informação de terceiros na descrição de produtos é um problema grave, inclusive de fabricantes. Isso porque, quando o cliente acessar as pesquisas da web sobre este produto, encontrará informações idênticas e muitas vezes inúteis para o seu perfil. Portanto, trabalhe as questões que mais se enquadram no interesse de seus consumidores; para informações mais técnicas, apresente o link do fabricante"
		 * ); c.setNomeCombo("Combo Titulo "+ i); c.setPreco(new
		 * BigDecimal(i*2));
		 * 
		 * SimpleDateFormat sf=new SimpleDateFormat("dd/MM/yyyy" );
		 * 
		 * try { c.setDataDisponibilidade(sf.parse("22/12/2015")); } catch
		 * (ParseException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); } for(int x=1;x<=5;x++){
		 * img.setCaminho("../resources/IMG/site/combos/0"+x+".jpg");
		 * img.setDescricao("Esta descrição se refere à imagem "+x+
		 * " que refere-se ao combo "+c.getNomeCombo()); img.setTitulo(
		 * "Titulo da imagem é: Titulo 00"+x); imagens.add(img); img=new
		 * Imagem(); } for(int z=1;z<=5;z++){ p.setCarenciaDias(1);
		 * p.setDescricao("Esta descrição de produto refere-se ao produto "+z+
		 * " que possui características adequadas para o combo selecionado "
		 * +c.getNomeCombo()); p.setNome("Produto Nº "+z);
		 * p.setUnidadeMedida("Unidade"); p.setValor(new BigDecimal(3*z));
		 * for(int x=1;x<=5;x++){
		 * img.setCaminho("../resources/IMG/site/combos/produtos/0"+x+".jpg");
		 * img.setDescricao("Esta descrição se refere à imagem "+x+
		 * " que refere-se ao combo "+c.getNomeCombo()); img.setTitulo(
		 * "Titulo da imagem é: Titulo 00"+x); imagensP.add(img); img=new
		 * Imagem(); } p.setImagens(imagensP); p.setQuantidade((long) (z*3));
		 * p.setUnidadeMedida("un"); produtos.add(p); p=new Produto(); }
		 * c.setImagens(imagens); c.setQuantidadeConvidados((long)i+2);
		 * c.setProdutos(produtos); combos.add(c); c=new Combo(); imagens=new
		 * ArrayList<Imagem>(); produtos=new ArrayList<>();
		 */
	}

	public String efetuarCompra() {
		HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
				.getRequest();
		HttpSession sessao = req.getSession();

		sessao.setAttribute("combo", this.comboSelecionada);
		return "finalizarCompra?faces-redirect=true";
	}

	public String consultarCombo(Combo combo) {
		HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
				.getRequest();
		HttpSession sessao = req.getSession();

		this.comboSelecionada = combo;
		sessao.setAttribute("combo", this.comboSelecionada);

		return "comboDetalhes?faces-redirect=true";

	}

	public List<Combo> getCombos() {
		return combos;
	}

	public void setCombos(List<Combo> combos) {
		this.combos = combos;
	}

	public Combo getComboSelecionada() {
		return comboSelecionada;
	}

	public void setComboSelecionada(Combo comboSelecionada) {
		this.comboSelecionada = comboSelecionada;
	}
}
