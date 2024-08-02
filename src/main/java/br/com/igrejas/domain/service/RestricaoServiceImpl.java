package br.com.igrejas.domain.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.igrejas.domain.dto.RestricaoDTO;
import br.com.igrejas.domain.exceptions.RestricaoNotFoundException;
import br.com.igrejas.domain.model.RestricaoModel;
import br.com.igrejas.infrastructure.repository.RestricaoRepositoryH2;

@Service
public class RestricaoServiceImpl implements RestricaoService {

	@Autowired
	private RestricaoRepositoryH2 repository;
	
	@Override
	public List<RestricaoModel> listarTodos() {
		List<RestricaoModel> retorno = new ArrayList<RestricaoModel>();
		repository.findAll().forEach(retorno::add);
		return retorno;
	}

	@Override
	public void incluir(RestricaoModel restricao) {
		repository.save(restricao);
		
	}

	@Override
	public void alterar(Long id, RestricaoDTO restricaoDTO) {
		RestricaoModel model = repository.findById(id).orElseThrow(()-> new RestricaoNotFoundException(id));
		model.setDescricao(restricaoDTO.getDescricao());
		repository.save(model);
		
	}

	@Override
	public RestricaoModel procurarPorId(Long id) {
		return repository.findById(id).orElseThrow(()-> new RestricaoNotFoundException(id));
	}

	@Override
	public void deletar(Long id) throws RestricaoNotFoundException {
		procurarPorId(id);
		repository.deleteById(id);
	}

}
