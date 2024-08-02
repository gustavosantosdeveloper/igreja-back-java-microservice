package br.com.igrejas.domain.service;

import java.util.List;

import br.com.igrejas.domain.dto.AlergiaDTO;
import br.com.igrejas.domain.model.AlergiaModel;

public interface AlergiaService {

	public List<AlergiaModel> listarTodos();

	public void incluir(AlergiaModel alergia);

	public AlergiaModel procurarPorId(Long id);

	public void excluir(Long id);
	
	public void alterar(Long id, AlergiaDTO dto);

}
