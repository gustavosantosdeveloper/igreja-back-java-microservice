package br.com.igrejas.domain.model;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="Alergia")
public class AlergiaModel {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;
	@Column(name="DESCRICAO_ALERGIA")
	private String descricaoAlergia;
	
	/*
	 * @ManyToMany(cascade = CascadeType.MERGE,fetch = FetchType.LAZY)
	 * 
	 * @JoinTable( name = "filho_alergias", joinColumns = @JoinColumn(name =
	 * "filho_id"), inverseJoinColumns = @JoinColumn(name = "alergia_id"))
	 */
	@JsonIgnore
	@ManyToMany(mappedBy = "alergias")
	private Set<FilhoModel> filhos;
	
}
