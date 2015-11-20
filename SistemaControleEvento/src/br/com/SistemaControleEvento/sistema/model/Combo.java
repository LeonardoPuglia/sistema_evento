package br.com.SistemaControleEvento.sistema.model;

import java.awt.Image;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import br.com.SistemaControleEvento.site.model.Imagem;

@Entity
@Table(name = "combo")
@NamedQueries({ @NamedQuery(name = "Combo.listar", query = "SELECT combo FROM Combo combo"),
	@NamedQuery(name = "Combo.buscarCodigo", query = "SELECT combo FROM Combo combo WHERE"
			          + " combo.codCombo = :codCombo")
})

public class Combo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_combo", unique = true)
	private Long codCombo;
	
	@ManyToMany(fetch = FetchType.EAGER)
	//@NotNull(message = "O campo produtos é obrigatório")
	@JoinColumn(name = "id_produtoFK" , referencedColumnName = "id_produto", nullable = false)
	private List<Produto> produtos;
	
	@OneToOne(fetch = FetchType.EAGER)
	//@NotNull(message = "O campo salão é obrigatório")
	@JoinColumn(name = "id_salaoFK" , referencedColumnName = "id_salao", nullable = false)
	private SalaoFesta salaofesta;
	
	//@NotNull(message="O campo é obrigatório")
	//@DecimalMin(value = "0.0",message = "Informe apenas valores positivos ou nulo para o campo preço")
	//@DecimalMax(value = "999999.9",message = "Informe apenas valores menores que 999.999,99" )
	@Column(name = "preco", precision = 7 , scale = 2, nullable = false)
	private BigDecimal preco;
	
	//@NotNull(message = "O campo quantidade de convidados é obrigatório")
	//@Min(value = 0 , message="Informe um valor igual ou maior que zero para o campo quantidade de convidados")
	//@Max(value = 9999, message = "Informe um valor menor que 10 mil para o campo quantidade de convidados")
	@Column(name = "quantidade_convidados", nullable = false)
	private Long quantidadeConvidados;
	
	//@NotEmpty(message = "O campo descrição é obrigatório")
	//@Size(min= 5 , max = 80 , message = "Tamanho inválido para o campo descrição(5 - 80)")
	@Column(name = "descricao" , length = 80 , nullable = false)
	private String  descricao;
	
	//@NotEmpty
	@Column
	private String caminhoImagem;
	
	//@NotEmpty(message = "O campo nome da combo é obrigatório")
	@Column
	private String nomeCombo;
	
	@Column(nullable=false)
	private Date dataDisponibilidade;
	
	@OneToMany
	private List<Imagem> imagens;
	
	//getters e setters

	public Long getCodCombo() {
		return codCombo;
	}

	public void setCodCombo(Long codCombo) {
		this.codCombo = codCombo;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public SalaoFesta getSalaofesta() {
		return salaofesta;
	}

	public void setSalaofesta(SalaoFesta salaofesta) {
		this.salaofesta = salaofesta;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public Long getQuantidadeConvidados() {
		return quantidadeConvidados;
	}

	public void setQuantidadeConvidados(Long quantidadeConvidados) {
		this.quantidadeConvidados = quantidadeConvidados;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return "Combo [codCombo=" + codCombo + ", produtos=" + produtos + ", salaofesta=" + salaofesta + ", preco="
				+ preco + ", quantidadeConvidados=" + quantidadeConvidados + ", descricao=" + descricao + "]";
	}

	public String getCaminhoImagem() {
		return caminhoImagem;
	}

	public void setCaminhoImagem(String caminhoImagem) {
		this.caminhoImagem = caminhoImagem;
	}

	public String getNomeCombo() {
		return nomeCombo;
	}

	public void setNomeCombo(String nomeCombo) {
		this.nomeCombo = nomeCombo;
	}

	public Date getDataDisponibilidade() {
		return dataDisponibilidade;
	}

	public void setDataDisponibilidade(Date dataDisponibilidade) {
		this.dataDisponibilidade = dataDisponibilidade;
	}

	public List<Imagem> getImagens() {
		return imagens;
	}

	public void setImagens(List<Imagem> imagens) {
		this.imagens = imagens;
	}
	
	

}
