package br.com.SistemaControleEvento.sistema.model;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import br.com.SistemaControleEvento.site.model.Imagem;

@Entity
@Table(name = "produto")
@NamedQueries({ @NamedQuery(name = "Produto.listar", query = "SELECT produto FROM Produto produto"),
	@NamedQuery(name = "Produto.buscarCodigo", query = "SELECT produto FROM Produto produto WHERE"
			          + " produto.codProduto = :codProduto")
})

public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_produto", unique = true)
	private Long codProduto;
	
	@NotEmpty(message = "O campo nome � obrigat�rio")
	@Column(name = "nome", length=50, nullable = false)
	private String nome;
	
	@NotEmpty(message = "O campo descri��o � obrigat�rio")
	@Size(min= 5 , max = 80 , message = "Tamanho inv�lido para o campo descri��o(5 - 80)")
	@Column(name = "descricao" , length = 80 , nullable = false)
	private String descricao;
	
	@NotNull(message = "O campo fornecedor � obrigat�rio")
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_fornecedorFK", referencedColumnName = "id_fornecedor", nullable = false)
	private Fornecedor fornecedor;
	
	@NotNull(message = "O campo valor � obrigat�rio")
	@DecimalMin(value = "0.0", message = "O valor informado n�o pode ser negativo")
	@DecimalMax(value = "999999.9", message = "O valor informado n�o pode ser superior a 1 milh�o" )
	@Column(name = "valor", precision = 7, scale = 2, nullable = false)
	private BigDecimal valor;
	
	@NotEmpty(message = "O campo unidade medida � obrigat�rio")
	@Column(name = "unidade_medida", length=50, nullable = false)
	private String unidadeMedida;
	
	@NotNull(message = "O campo carencia dias � obrigat�rio")
	@Min(value = 0, message = "A car�ncia de dias n�o pode ser negativa")
	@Column(name = "carencia_dias", nullable = false)
	private int carenciaDias;
	
	@NotNull
	@Column
	private Long quantidade;
	
	@Column
	@OneToMany
	private List<Imagem> imagens;
	
	
	//getter e setters

	public Long getCodProduto() {
		return codProduto;
	}

	public void setCodProduto(Long codProduto) {
		this.codProduto = codProduto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public String getUnidadeMedida() {
		return unidadeMedida;
	}

	public void setUnidadeMedida(String unidadeMedida) {
		this.unidadeMedida = unidadeMedida;
	}

	public int getCarenciaDias() {
		return carenciaDias;
	}

	public void setCarenciaDias(int carenciaDias) {
		this.carenciaDias = carenciaDias;
	}

	@Override
	public String toString() {
		return "Produto [codProduto=" + codProduto + ", nome=" + nome + ", descricao=" + descricao + ", fornecedor="
				+ fornecedor + ", valor=" + valor + ", unidadeMedida=" + unidadeMedida + ", carenciaDias="
				+ carenciaDias + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codProduto == null) ? 0 : codProduto.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		if (codProduto == null) {
			if (other.codProduto != null)
				return false;
		} else if (!codProduto.equals(other.codProduto))
			return false;
		return true;
	}

	public Long getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Long quantidade) {
		this.quantidade = quantidade;
	}

	public List<Imagem> getImagens() {
		return imagens;
	}

	public void setImagens(List<Imagem> imagens) {
		this.imagens = imagens;
	}
	
	
	
	
	
}
