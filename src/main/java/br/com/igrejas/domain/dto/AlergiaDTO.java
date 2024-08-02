package br.com.igrejas.domain.dto;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.igrejas.domain.model.FilhoModel;
import lombok.Data;

@Data
public class AlergiaDTO {
	private Long id;
	private String descricaoAlergia;
	@JsonIgnore
	private Set<FilhoModel> filhos;
}
