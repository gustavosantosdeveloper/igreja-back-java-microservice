package br.com.igrejas.domain.repository;

import java.util.List;

import br.com.igrejas.domain.model.AlergiaModel;

public interface AlergiaRepository {
	public List<AlergiaModel> listarTodos();

	public void salvar(AlergiaModel alergia);

	public AlergiaModel procurarPorId(Long id);

	public void excluir(Long id);
}
