package br.com.igrejas.infrastructure.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.igrejas.domain.model.RestricaoModel;

public interface RestricaoRepositoryH2 extends CrudRepository<RestricaoModel, Long> {

}
