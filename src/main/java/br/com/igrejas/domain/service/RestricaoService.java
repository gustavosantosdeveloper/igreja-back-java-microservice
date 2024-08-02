package br.com.igrejas.domain.service;

import java.util.List;

import br.com.igrejas.domain.dto.RestricaoDTO;
import br.com.igrejas.domain.model.RestricaoModel;

public interface RestricaoService {

	public List<RestricaoModel> listarTodos();

	public void incluir(RestricaoModel converteRestricaiDTOToEntity);

	public void alterar(Long id, RestricaoDTO restricaoDTO);

	public RestricaoModel procurarPorId(Long id);

	public void deletar(Long id);

	
}
