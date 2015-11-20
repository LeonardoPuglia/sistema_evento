package br.com.SistemaControleEvento.sistema.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "salao_festa")
@NamedQueries({ @NamedQuery(name = "SalaoFesta.listar", query = "SELECT salao FROM SalaoFesta salao"),
	@NamedQuery(name = "SalaoFesta.buscarCodigo", query = "SELECT salao FROM SalaoFesta salao WHERE"
			          + " salao.codSalao = :codSalao")
	})
public class SalaoFesta {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_salao", unique = true)
	private Long codSalao;
	
	@NotEmpty(message = "O campo nome é obrigatório")
	@Column(name = "nome", length=50, nullable = false)
	private String nome;
	
	@NotEmpty(message = "O campo descrição é obrigatório")
	@Size(min= 5 , max = 80 , message = "Tamanho inválido para o campo descrição(5 - 80)")
	@Column(name = "descricao" , length = 80 , nullable = false)
	private String descricao;
	
	@NotEmpty(message = "O campo nome contato é obrigatório")
	@Column(name = "nome_contato", length=50, nullable = false)
	private String nomeContato;
	
	@NotEmpty(message = "O campo telefone contato é obrigatório")
	@Column(name = "tel_contato", length=20, nullable = false)
	private String telefoneContato;
	
	@Column(name = "email_contato", length=30, nullable = true)
	private String emailContato;
	
	@NotEmpty(message = "O campo logadouro é obrigatório")
	@Column(name = "logadouro", length=50, nullable = false)
	private String logadouro;
	
	@NotNull(message = "O campo numero é obrigatório")
	@Min(value = 0, message = "Informe apenas valores nulos ou positivos para o campo número")
	@Column(name = "numero", nullable = false)
	private Long numero;
	
	@NotEmpty(message = "O campo complemento é obrigatório")
	@Column(name = "complemento", length=30, nullable = false)
	private String complemento;
	
	@NotNull(message = "O campo CEP é obrigatório")
	@Column(name = "cep", length=8, nullable = false)
	private Long cep;
	
	@NotEmpty(message = "O campo bairro é obrigatório")
	@Column(name = "bairro", length=30, nullable = false)
	private String bairro;
	
	@NotEmpty(message = "O campo cidade é obrigatório")
	@Column(name = "cidade", length=30, nullable = false)
	private String cidade;
	
	@NotEmpty(message = "O campo UF é obrigatório")
	@Column(name = "uf", length=30, nullable = false)
	private String uf;
	
	//getters e setters

	public Long getCodSalao() {
		return codSalao;
	}

	public void setCodSalao(Long codSalao) {
		this.codSalao = codSalao;
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

	public String getNomeContato() {
		return nomeContato;
	}

	public void setNomeContato(String nomeContato) {
		this.nomeContato = nomeContato;
	}

	public String getTelefoneContato() {
		return telefoneContato;
	}

	public void setTelefoneContato(String telefoneContato) {
		this.telefoneContato = telefoneContato;
	}

	public String getEmailContato() {
		return emailContato;
	}

	public void setEmailContato(String emailContato) {
		this.emailContato = emailContato;
	}

	public String getLogadouro() {
		return logadouro;
	}

	public void setLogadouro(String logadouro) {
		this.logadouro = logadouro;
	}

	public Long getNumero() {
		return numero;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public Long getCep() {
		return cep;
	}

	public void setCep(Long cep) {
		this.cep = cep;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	@Override
	public String toString() {
		return "SalaoFesta [codSalao=" + codSalao + ", nome=" + nome + ", descricao=" + descricao + ", nomeContato="
				+ nomeContato + ", telefoneContato=" + telefoneContato + ", emailContato=" + emailContato
				+ ", logadouro=" + logadouro + ", numero=" + numero + ", complemento=" + complemento + ", cep=" + cep
				+ ", bairro=" + bairro + ", cidade=" + cidade + ", uf=" + uf + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codSalao == null) ? 0 : codSalao.hashCode());
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
		SalaoFesta other = (SalaoFesta) obj;
		if (codSalao == null) {
			if (other.codSalao != null)
				return false;
		} else if (!codSalao.equals(other.codSalao))
			return false;
		return true;
	}
	
	
	
}
