package br.com.igrejas.infrastructure.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.igrejas.domain.model.MembroResponsavelModel;

@Repository
public interface MembroResponsavelRepositoryInterfaceH2 extends CrudRepository<MembroResponsavelModel, Long> {

}
