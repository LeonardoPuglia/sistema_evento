package br.com.SistemaControleEvento.sistema.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.br.CPF;

@Entity
@Table(name = "cliente")
@NamedQueries({
	@NamedQuery(name = "Cliente.listar", query = "SELECT cliente FROM Cliente cliente" ),
	@NamedQuery(name = "Cliente.buscarCodigo" , query = "SELECT cliente FROM Cliente cliente "
			+ "WHERE cliente.codCliente = :codCliente" )
})
		
		

public class Cliente implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_cliente", unique = true)
	private Long codCliente;
	
	@NotNull(message = "O CPF � obrigat�rio")
	@CPF(message = "O CPF informado � inv�lido")
	@Column(name = "cpf", unique = true)
	private String cpf;
	
	@NotEmpty(message = "O campo nome � obrigat�rio")
	@Column(name = "nome", nullable = false)
	private String nome;
	
	@NotEmpty(message = "O campo sobrenome � obrigat�rio")
	@Column(name = "sobrenome", nullable = false)
	private String sobrenome;
	
	
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dataNascimento;
	
	@NotNull(message = "O campo telefone  � obrigat�rio")
	@Column(name = "telefone",  nullable = false)
	private Long telefone;
	
	@NotNull(message = "O campo celular � obrigat�rio")
	@Column(name = "celular",nullable = false)
	private Long celular;
	
	@Column(name = "email",unique=true, nullable = true)
	private String email;
	
	@Column(name = "tel_recado", nullable = true)
	private Long telRecado;
	
	@Column(name = "nome_recado", nullable = true)
	private String nomeRecado;
	
	@NotEmpty(message = "O campo logadouro � obrigat�rio")
	@Column(name = "logadouro", nullable = false)
	private String logadouro;
	
	@NotNull(message = "O campo numero � obrigat�rio")
	@Min(value = 0, message = "Informe apenas valores nulos ou positivos para o campo n�mero")
	@Column(name = "numero", nullable = false)
	private Long numero;
	
	@NotEmpty(message = "O campo complemento � obrigat�rio")
	@Column(name = "complemento", nullable = false)
	private String Complemento;
	
	@NotEmpty(message = "O campo bairro � obrigat�rio")
	@Column(name = "bairro", nullable = false)
	private String bairro;
	
	@NotEmpty(message = "O campo cidade � obrigat�rio")
	@Column(name = "cidade",nullable = false)
	private String cidade;
	
	@NotEmpty(message = "O campo UF � obrigat�rio")
	@Column(name = "uf", nullable = false)
	private String uf;
	
	@NotNull(message = "O campo CEP � obrigat�rio")
	@Column(name = "cep", nullable = false)
	private Long cep;
	
	@NotEmpty(message="O campo Senha é obrigatório")
	@Column
	private String senha;
	//getters e setters

	public Long getCodCliente() {
		return codCliente;
	}

	public void setCodCliente(Long codCliente) {
		this.codCliente = codCliente;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Long getTelefone() {
		return telefone;
	}

	public void setTelefone(Long telefone) {
		this.telefone = telefone;
	}

	public Long getCelular() {
		return celular;
	}

	public void setCelular(Long celular) {
		this.celular = celular;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getTelRecado() {
		return telRecado;
	}

	public void setTelRecado(Long telRecado) {
		this.telRecado = telRecado;
	}

	public String getNomeRecado() {
		return nomeRecado;
	}

	public void setNomeRecado(String nomeRecado) {
		this.nomeRecado = nomeRecado;
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
		return Complemento;
	}

	public void setComplemento(String complemento) {
		Complemento = complemento;
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

	public Long getCep() {
		return cep;
	}

	public void setCep(Long cep) {
		this.cep = cep;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public String toString() {
		return "Cliente [codCliente=" + codCliente + ", cpf=" + cpf + ", nome=" + nome + ", sobrenome=" + sobrenome
				+ ", dataNascimento=" + dataNascimento + ", telefone=" + telefone + ", celular=" + celular + ", email="
				+ email + ", telRecado=" + telRecado + ", nomeRecado=" + nomeRecado + ", logadouro=" + logadouro
				+ ", numero=" + numero + ", Complemento=" + Complemento + ", bairro=" + bairro + ", cidade=" + cidade
				+ ", uf=" + uf + ", cep=" + cep + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codCliente == null) ? 0 : codCliente.hashCode());
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
		Cliente other = (Cliente) obj;
		if (codCliente == null) {
			if (other.codCliente != null)
				return false;
		} else if (!codCliente.equals(other.codCliente))
			return false;
		return true;
	}
	
	
}
