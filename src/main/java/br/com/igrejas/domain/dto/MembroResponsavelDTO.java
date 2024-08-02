package br.com.igrejas.domain.dto;

import lombok.Data;

@Data
public class MembroResponsavelDTO {

	
	private Long id;
	private String nome;
	private String cpf;
	private String logradouro;
	private String bairro;
	private String cep;
	private String estado;
	private String cidade;
	private String pais;
	private String telefone;
	private String email;
}
