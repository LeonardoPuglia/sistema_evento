package br.com.SistemaControleEvento.site.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table
public class Imagem {
	@Id
	@GeneratedValue
	private Long id;
	@NotEmpty
	@Column(nullable=false)
	private String caminho;
	@NotEmpty
	@Column(nullable=true)
	private String descricao;
	@NotEmpty
	@Column(nullable=false)
	private String titulo;
	
	public Long getId() {
		return id;
	}
	public String getCaminho() {
		return caminho;
	}
	public void setCaminho(String caminho) {
		this.caminho = caminho;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
}
