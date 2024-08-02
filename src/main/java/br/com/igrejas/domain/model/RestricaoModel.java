package br.com.igrejas.domain.model;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="Restricao")
public class RestricaoModel {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;
	private String descricao;
	
	/*
	 * @ManyToMany(cascade = CascadeType.MERGE,fetch = FetchType.LAZY)
	 * 
	 * @JoinTable( name = "filho_restricoes", joinColumns = @JoinColumn(name =
	 * "filho_id"), inverseJoinColumns = @JoinColumn(name = "restricao_id"))
	 */
	@ManyToMany(mappedBy = "restricoes")
	@JsonIgnore
	private Set<FilhoModel> filhos;

}
