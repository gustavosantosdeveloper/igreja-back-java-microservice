package br.com.igrejas.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.igrejas.domain.model.FilhoModel;
import br.com.igrejas.domain.repository.FilhoRepositoryInterface;
import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Service
public class FilholServiceImpl implements FilhoService {

	@Autowired
	private FilhoRepositoryInterface dao;
	
	public List<FilhoModel> listarTodos(Long responsavelId) {
		return dao.listarTodos(responsavelId);
	}

	@Transactional(value = TxType.REQUIRED)
	public void salvar(FilhoModel entity) {
		dao.salvar(entity);
	}

	public FilhoModel procurarPorId(Long id) {
		return dao.procurarPorId(id);
	}

	public void excluir(Long id) {
		dao.excluir(id);
		
	}

}
