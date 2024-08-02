package br.com.igrejas.domain.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.igrejas.domain.model.FilhoModel;
import lombok.Data;

@Data
public class RestricaoDTO {
	private Long id;
	private String descricao;
	@JsonIgnore
	private List<FilhoModel> filhos;
}
