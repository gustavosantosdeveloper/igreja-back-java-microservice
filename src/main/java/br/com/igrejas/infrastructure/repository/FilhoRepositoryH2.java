package br.com.igrejas.infrastructure.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.igrejas.domain.model.FilhoModel;

@Repository
public interface FilhoRepositoryH2 extends CrudRepository<FilhoModel, Long> {

	public Iterable<FilhoModel> findByResponsavelId(Long id);
	
	
}
