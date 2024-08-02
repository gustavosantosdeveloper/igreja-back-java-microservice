package br.com.igrejas.domain.dto;

import java.util.List;

import lombok.Data;

@Data
public class FilhoDTO {
	private Long id;
	private String celular;
	private String nome;
	private List<AlergiaDTO> alergias;
	private List<RestricaoDTO> restricoes;
	private Long responsavelId;
}
