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

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "fornecedor")
@NamedQueries({ @NamedQuery(name = "Fornecedor.listar", query = "SELECT fornecedor FROM Fornecedor fornecedor"),
	@NamedQuery(name = "Fornecedor.buscarCodigo", query = "SELECT fornecedor FROM Fornecedor fornecedor WHERE"
			          + " fornecedor.codFornecedor = :codFornecedor")
})

public class Fornecedor {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_fornecedor", unique = true)
	private Long codFornecedor;
	
	@NotEmpty(message = "O campo CNPJ é obrigatório")
	@Column(name = "cnpj", length = 20 ,nullable = false, unique = true)
	private String cnpj;
	
	@NotEmpty(message = "O campo nome fantasia é obrigatório")
	@Column(name = "nome_fantasia", length=30, nullable = false)
	private String nomeFantasia;
	
	@NotEmpty(message = "O campo razão social é obrigatório")
	@Column(name = "razao_social", length=50, nullable = false)
	private String razaoSocial;
	
	@NotEmpty(message = "O campo telefone contato é obrigatório")
	@Column(name = "tel_contato", length=13, nullable = false)
	private String telefoneContato;
	
	@NotEmpty(message = "O campo nome contato é obrigatório")
	@Column(name = "nome_contato", length=50, nullable = false)
	private String nomeContato;
	
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

	public Long getCodFornecedor() {
		return codFornecedor;
	}

	public void setCodFornecedor(Long codFornecedor) {
		this.codFornecedor = codFornecedor;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getTelefoneContato() {
		return telefoneContato;
	}

	public void setTelefoneContato(String telefoneContato) {
		this.telefoneContato = telefoneContato;
	}

	public String getNomeContato() {
		return nomeContato;
	}

	public void setNomeContato(String nomeContato) {
		this.nomeContato = nomeContato;
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
		return "Fornecedor [codFornecedor=" + codFornecedor + ", cnpj=" + cnpj + ", nomeFantasia=" + nomeFantasia
				+ ", razaoSocial=" + razaoSocial + ", telefoneContato=" + telefoneContato + ", nomeContato="
				+ nomeContato + ", emailContato=" + emailContato + ", logadouro=" + logadouro + ", numero=" + numero
				+ ", complemento=" + complemento + ", bairro=" + bairro + ", cidade=" + cidade + ", uf=" + uf + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codFornecedor == null) ? 0 : codFornecedor.hashCode());
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
		Fornecedor other = (Fornecedor) obj;
		if (codFornecedor == null) {
			if (other.codFornecedor != null)
				return false;
		} else if (!codFornecedor.equals(other.codFornecedor))
			return false;
		return true;
	}
	
	
	
	
	
}
