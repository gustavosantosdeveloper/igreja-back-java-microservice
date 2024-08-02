package br.com.igrejas.infrastructure.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

import br.com.igrejas.domain.model.AlergiaModel;
import br.com.igrejas.domain.repository.AlergiaRepository;

public class AlergiaRepositoryH2Impl implements AlergiaRepository {

	@Autowired
	@Lazy
	private AlergiaRepositoryH2 alergiaRepositoryH2;
	
	@Override
	public List<AlergiaModel> listarTodos() {
		List<AlergiaModel> result = new ArrayList<AlergiaModel>();
		alergiaRepositoryH2.findAll().forEach(result::add);
		return result;
	}

	@Override
	public void salvar(AlergiaModel alergia) {
		// TODO Auto-generated method stub
		
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

}
