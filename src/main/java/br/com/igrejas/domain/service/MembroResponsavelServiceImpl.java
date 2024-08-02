package br.com.igrejas.domain.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.igrejas.domain.model.MembroResponsavelModel;
import br.com.igrejas.infrastructure.repository.MembroResponsavelRepositoryInterfaceH2;

@Service
public class MembroResponsavelServiceImpl implements MembroResponsavelService {

	@Autowired
	private MembroResponsavelRepositoryInterfaceH2 repository;
	
	
	@Override
	public List<MembroResponsavelModel> listarTodos() {
		List<MembroResponsavelModel> result = new ArrayList<MembroResponsavelModel>();
		repository.findAll().forEach(result::add);
		return result;
	}

	@Override
	public void salvar(MembroResponsavelModel membro) {
		repository.save(membro);
		
	}

	@Override
	public void excluir(Long id) {
		repository.deleteById(id);		
	}

	@Override
	public MembroResponsavelModel procurarPorId(Long id) {
		return repository.findById(id).orElse(null);
	}

}
