package br.com.igrejas.infrastructure.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.igrejas.domain.model.MembroResponsavelModel;
import br.com.igrejas.domain.repository.MembroResponsavelRepositoryInterface;


public class MembroResponsavelRepositoryH2Impl implements MembroResponsavelRepositoryInterface {

	
	@Autowired
	private MembroResponsavelRepositoryInterfaceH2 repositoryH2;
	
	@Override
	public List<MembroResponsavelModel> listarTodos() {
		List<MembroResponsavelModel> result = new ArrayList<MembroResponsavelModel>();
		repositoryH2.findAll().forEach(result::add);
		return result;
	}

	@Override
	public void salvar(MembroResponsavelModel membro) {
		repositoryH2.save(membro);
	}

	@Override
	public void excluir(MembroResponsavelModel membro) {
		repositoryH2.delete(membro);
	}

	@Override
	public MembroResponsavelModel procurarPorId(Long id) {
		return repositoryH2.findById(id).orElse(null);
	}

	
}
