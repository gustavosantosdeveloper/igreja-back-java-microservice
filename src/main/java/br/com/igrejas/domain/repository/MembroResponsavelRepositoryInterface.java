package br.com.igrejas.domain.repository;

import java.util.List;

import br.com.igrejas.domain.model.MembroResponsavelModel;

public interface MembroResponsavelRepositoryInterface {

	public List<MembroResponsavelModel> listarTodos();
	public void salvar(MembroResponsavelModel membro);
	public void excluir(MembroResponsavelModel membro);
	public MembroResponsavelModel procurarPorId(Long id);
}
