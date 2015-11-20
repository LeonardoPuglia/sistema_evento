package br.com.SistemaControleEvento.sistema.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "convidado")
@NamedQueries({ @NamedQuery(name = "Convidado.listar", query = "SELECT convidado FROM Convidado convidado"),
	@NamedQuery(name = "Convidado.buscarCodigo", query = "SELECT convidado FROM Convidado convidado WHERE"
			          + " convidado.codConvidado = :codConvidado")
})
public class Convidado {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_convidado", unique = true)
	private Long codConvidado;
	
	@NotEmpty(message = "O campo nome completo é obrigatório")
	@Column(name = "nome_completo", length=50, nullable = false)
	private String nomeCompleto;
	
	@NotEmpty(message = "O campo RG é obrigatório")
	@Column(name = "rg", length=12, nullable = false)
	private String rg;
	
	
	@Column(name = "comparecer_festa", nullable = false)
	private boolean comparecerFesta;
	
	@NotEmpty(message = "O campo email é obrigatório")
	@Column(name = "email", length=30, nullable = false)
	private String email;

	
	//getters e setters
	
	public Long getCodConvidado() {
		return codConvidado;
	}

	public void setCodConvidado(Long codConvidado) {
		this.codConvidado = codConvidado;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public boolean isComparecerFesta() {
		return comparecerFesta;
	}

	public void setComparecerFesta(boolean comparecerFesta) {
		this.comparecerFesta = comparecerFesta;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Convidado [codConvidado=" + codConvidado + ", nomeCompleto=" + nomeCompleto + ", rg=" + rg
				+ ", comparecerFesta=" + comparecerFesta + ", email=" + email + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codConvidado == null) ? 0 : codConvidado.hashCode());
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
		Convidado other = (Convidado) obj;
		if (codConvidado == null) {
			if (other.codConvidado != null)
				return false;
		} else if (!codConvidado.equals(other.codConvidado))
			return false;
		return true;
	}
	
	
	
	
}
