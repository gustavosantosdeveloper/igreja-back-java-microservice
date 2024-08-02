package br.com.igrejas.domain.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class MembroResponsavel {

	private Long id;
	private String nome;
	private String cpf;
	private String logradouro;
	private String bairro;
	private String cep;
	private String estado;
	private String cidade;
	private String pais;

	
	public MembroResponsavel(Long id, String nome, String cpf, String logradouro, String bairro, String cep,
			String estado, String cidade, String pais) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.logradouro = logradouro;
		this.bairro = bairro;
		this.cep = cep;
		this.estado = estado;
		this.cidade = cidade;
		this.pais = pais;
	}
	
	
}
