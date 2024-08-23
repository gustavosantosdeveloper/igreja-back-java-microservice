package br.com.igrejas.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.igrejas.domain.builder.ConverterDataUtil;
import br.com.igrejas.domain.dto.AlergiaDTO;
import br.com.igrejas.domain.model.AlergiaModel;
import br.com.igrejas.domain.repository.AlergiaRepository;

@Service
public class AlergiaServiceImpl implements AlergiaService {

	@Autowired
	private AlergiaRepository repository;
	
	@Override
	public List<AlergiaModel> listarTodos() {
		return repository.listarTodos();
	}

	@Override
	public void incluir(AlergiaModel alergia) {
		repository.salvar(alergia);
		
	}

	@Override
	public AlergiaModel procurarPorId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void excluir(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void alterar(Long id, AlergiaDTO dto) {
		AlergiaDTO dtoAux = new AlergiaDTO();
		dtoAux = ConverterDataUtil.converteAlergiEntityToDTO(repository.procurarPorId(id));
		dtoAux.setDescricaoAlergia(dto.getDescricaoAlergia());
		repository.salvar(ConverterDataUtil.converteAlergiaDTOToEntity(dtoAux));
	}

	

}
