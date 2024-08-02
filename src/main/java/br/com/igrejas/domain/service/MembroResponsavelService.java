package br.com.igrejas.domain.service;

import java.util.List;

import br.com.igrejas.domain.model.MembroResponsavelModel;

public interface MembroResponsavelService {
	public List<MembroResponsavelModel> listarTodos();
	public void salvar(MembroResponsavelModel membro);
	public void excluir(Long id);
	public MembroResponsavelModel procurarPorId(Long id);
}
