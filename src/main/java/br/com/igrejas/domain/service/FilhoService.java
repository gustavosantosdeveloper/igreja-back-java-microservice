package br.com.igrejas.domain.service;

import java.util.List;

import br.com.igrejas.domain.model.FilhoModel;

public interface FilhoService {
	
	public List<FilhoModel> listarTodos(Long responsavelId);

	public void salvar(FilhoModel filho);

	public FilhoModel procurarPorId(Long id);

	public void excluir(Long id);
}
