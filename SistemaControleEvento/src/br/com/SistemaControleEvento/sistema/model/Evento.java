package br.com.SistemaControleEvento.sistema.model;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "Evento")
@NamedQueries({ @NamedQuery(name = "Evento.listar", query = "SELECT evento FROM Evento evento"),
	@NamedQuery(name = "Evento.buscarCodigo", query = "SELECT evento FROM Evento evento WHERE"
			          + " evento.codEvento = :codEvento")
})
public class Evento {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_evento", unique = true)
	private Long codEvento;
	
	@OneToOne(fetch = FetchType.EAGER)
	@NotNull(message = "O campo cliente � obrigat�rio")
	@JoinColumn(name = "id_clienteFK", referencedColumnName = "id_cliente", nullable = false)
	private Cliente cliente;
	
	@OneToOne(fetch = FetchType.EAGER)
	@NotNull(message = "O campo sal�o � obrigat�rio")
	@JoinColumn(name = "id_salaoFK", referencedColumnName = "id_salao", nullable = false)
	private SalaoFesta salaofesta;
	
	@NotNull(message="O campo valor � obrigat�rio")
	@DecimalMin(value = "0.0",message = "Informe apenas valores positivos ou nulo")
	@DecimalMax(value = "999999.9",message = "Informe apenas valores menores que 999.999,99" )
	@Column(name = "valor", precision = 7 , scale = 2, nullable = false)
	private BigDecimal valor;
	
	@NotEmpty(message = "O campo observa��es � obrigat�rio")
	@Size(min= 5 , max = 80 , message = "Tamanho inv�lido para o campo observa��es(5 - 80)")
	@Column(name = "observacoes" , length = 80 , nullable = false)
	private String observacoes;
	
	@OneToOne
	@NotNull
	@JoinColumn
	private Combo combo;
	
	@NotNull
	@Column
	private Long quantidadeConvidados;
	
	@Column
	@NotNull
	private Date dataHora;
	
	//getters e setters

	public Long getCodEvento() {
		return codEvento;
	}

	public void setCodEvento(Long codEvento) {
		this.codEvento = codEvento;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public SalaoFesta getSalaofesta() {
		return salaofesta;
	}

	public void setSalaofesta(SalaoFesta salaofesta) {
		this.salaofesta = salaofesta;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	@Override
	public String toString() {
		return "Evento [codEvento=" + codEvento  + ", cliente=" + cliente + ", salaofesta="
				+ salaofesta + ", dataHora=" + getDataHora() + ", valor=" + valor + ", observacoes=" + observacoes + "]";
	}

	public Combo getCombo() {
		return combo;
	}

	public void setCombo(Combo combo) {
		this.combo = combo;
	}

	public Long getQuantidadeConvidados() {
		return quantidadeConvidados;
	}

	public void setQuantidadeConvidados(Long quantidadeConvidados) {
		this.quantidadeConvidados = quantidadeConvidados;
	}

	public Date getDataHora() {
		return dataHora;
	}

	public void setDataHora(Date dataHora) {
		this.dataHora = dataHora;
	}
	
	
	
	
}
