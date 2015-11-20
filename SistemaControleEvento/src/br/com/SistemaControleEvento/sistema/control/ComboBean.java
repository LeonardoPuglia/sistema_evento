package br.com.SistemaControleEvento.sistema.control;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.SistemaControleEvento.sistema.control.DAO.ComboDAO;
import br.com.SistemaControleEvento.sistema.control.DAO.ProdutoDAO;
import br.com.SistemaControleEvento.sistema.control.DAO.SalaoFestaDAO;
import br.com.SistemaControleEvento.sistema.model.Combo;
import br.com.SistemaControleEvento.sistema.model.Produto;
import br.com.SistemaControleEvento.sistema.model.SalaoFesta;
import br.com.SistemaControleEvento.util.FacesUtil;

@ManagedBean
@ViewScoped
public class ComboBean {

	private Combo combo;
	
	private List<Combo> listaCombo;
	
	private List<Combo> listaComboFiltrado;
	
	private List<Produto> comboProduto;
	
	private List<SalaoFesta> comboSalao;
	
	private ArrayList<Produto> listaProduto;
	
	
	public Combo getCombo() {
		if(combo == null)
			novo();
		return combo;
	}
	
	public void setCombo(Combo combo) {
		this.combo = combo;
	}
	
	public List<Combo> getListaCombo() {
		return listaCombo;
	}
	
	public void setListaCombo(List<Combo> listaCombo) {
		this.listaCombo = listaCombo;
	}
	
	public List<Combo> getListaComboFiltrado() {
		return listaComboFiltrado;
	}
	
	public void setListaComboFiltrado(List<Combo> listaComboFiltrado) {
		this.listaComboFiltrado = listaComboFiltrado;
	}
	
	public List<Produto> getComboProduto() {
		return comboProduto;
	}
	
	public void setComboProduto(List<Produto> comboProduto) {
		this.comboProduto = comboProduto;
	}
	
	public List<SalaoFesta> getComboSalao() {
		return comboSalao;
	}
	
	public void setComboSalao(List<SalaoFesta> comboSalao) {
		this.comboSalao = comboSalao;
	}
	
	public ArrayList<Produto> getListaProduto() {
		if(listaProduto == null)
			listaProduto = new ArrayList<>();
		return listaProduto;
	}
	
	public void setListaProduto(ArrayList<Produto> listaProduto) {
		this.listaProduto = listaProduto;
	}
	public void novo(){
		combo = new Combo();
	}
	
	public void carregarCombos(){
		try{
			novo();
			ProdutoDAO produtoDAO = new ProdutoDAO();
			SalaoFestaDAO salaoDAO = new SalaoFestaDAO();
			
			comboProduto = produtoDAO.listar();
			comboSalao = salaoDAO.listar();
		}catch( RuntimeException e){
			e.printStackTrace();
			FacesUtil.addMsgError("Erro ao listar os produtos e de salões de festas");
		}
	}
	
	public void listar(){
		try{
			ComboDAO dao = new ComboDAO();
			listaCombo = dao.listar();
			
		}catch(RuntimeException e){
			e.printStackTrace();
			FacesUtil.addMsgError("Erro ao listar as combos");
		}
	}
	
	public void salvar(){
		try{
			ComboDAO dao = new ComboDAO();
			dao.salvar(combo);
			FacesUtil.addMsgInfo("Combo cadastrada com sucesso");
			novo();
			listar();
			
		}catch(RuntimeException e){
			e.printStackTrace();
			FacesUtil.addMsgError("Erro ao cadastrar nova combo");
		}
	}
	
	public void editar(){
		try{
			ComboDAO dao = new ComboDAO();
			dao.editar(combo);
			FacesUtil.addMsgInfo("Combo atualizada com sucesso");
			novo();
			listar();
			
		}catch(RuntimeException e){
			e.printStackTrace();
			FacesUtil.addMsgError("Erro ao atualizar a combo");
		}
	}
	
	public void excluir(){
		try{
			ComboDAO dao = new ComboDAO();
			dao.excluir(combo);
			FacesUtil.addMsgInfo("Combo excluída com sucesso");
			novo();
			listar();
			
		}catch(RuntimeException e){
			e.printStackTrace();
			FacesUtil.addMsgError("Erro ao excluir a combo");
		}
	}
	
	public void adicionar(Produto produto){
		
		System.out.println(produto);
		//produto.setQuantidade(1L);
		//listaProduto.add(produto);
		
		
	}
}


