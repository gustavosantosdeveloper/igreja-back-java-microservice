package br.com.igrejas.domain.repository;

import java.util.List;

import br.com.igrejas.domain.model.FilhoModel;

public interface FilhoRepositoryInterface {

	public List<FilhoModel> listarTodos(Long responsavelId);
	public void salvar(FilhoModel filho);
	public void excluir(Long id);
	public FilhoModel procurarPorId(Long id);
	
}
