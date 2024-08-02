package br.com.igrejas.infrastructure.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.igrejas.domain.model.AlergiaModel;

@Repository
public interface AlergiaRepositoryH2 extends CrudRepository<AlergiaModel, Long> {

}
