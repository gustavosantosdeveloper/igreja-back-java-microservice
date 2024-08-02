package br.com.igrejas.domain.repository;

import java.util.List;

import br.com.igrejas.domain.model.RestricaoModel;

public interface RestricaoRepository {
	public List<RestricaoModel> listarTodos();
}
