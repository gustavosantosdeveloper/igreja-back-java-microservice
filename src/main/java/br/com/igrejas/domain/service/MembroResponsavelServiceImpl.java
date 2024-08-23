package br.com.igrejas.domain.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.igrejas.domain.builder.ConverterDataUtil;
import br.com.igrejas.domain.dto.MembroResponsavelDTO;
import br.com.igrejas.domain.exceptions.MembroNotFoundException;
import br.com.igrejas.domain.model.MembroResponsavelModel;
import br.com.igrejas.infrastructure.repository.MembroResponsavelRepositoryInterfaceH2;

@Service
public class MembroResponsavelServiceImpl implements MembroResponsavelService {

	@Autowired
	private MembroResponsavelRepositoryInterfaceH2 repository;
	
	
	@Override
	public List<MembroResponsavelDTO> listarTodos() {
		List<MembroResponsavelDTO> result = new ArrayList<MembroResponsavelDTO>();
		repository.findAll().forEach(membro->{
			result.add(ConverterDataUtil.converteMembroEntityToDTO(membro));
		});
		return result;
	}

	@Override
	public void salvar(MembroResponsavelDTO dto) {
		repository.save(ConverterDataUtil.converteMembroDTOToEntity(dto));
		
		
	}

	@Override
	public void excluir(Long id) {
		repository.deleteById(id);		
	}

	@Override
	public MembroResponsavelDTO procurarPorId(Long id) throws MembroNotFoundException {
		MembroResponsavelModel model = repository.findById(id).orElseThrow(() -> new MembroNotFoundException());
		return ConverterDataUtil.converteMembroEntityToDTO(model);
	}

	@Override
	public void alterar(Long id, MembroResponsavelDTO dto) throws MembroNotFoundException {
		MembroResponsavelModel model = ConverterDataUtil.converteMembroDTOToEntity(procurarPorId(id));
		model = ConverterDataUtil.converteMembroDTOToEntity(dto);
		repository.save(model);
	}

}
