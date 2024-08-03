package br.com.igrejas.domain.service;

import java.util.List;

import br.com.igrejas.domain.dto.MembroResponsavelDTO;
import br.com.igrejas.domain.exceptions.MembroNotFoundException;

public interface MembroResponsavelService {
	public List<MembroResponsavelDTO> listarTodos();
	public void salvar(MembroResponsavelDTO dto);
	public void excluir(Long id);
	public MembroResponsavelDTO procurarPorId(Long id) throws MembroNotFoundException;
	public void alterar(Long id,  MembroResponsavelDTO dto) throws MembroNotFoundException;
}
