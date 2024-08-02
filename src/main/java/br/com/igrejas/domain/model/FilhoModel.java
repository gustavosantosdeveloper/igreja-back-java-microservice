package br.com.igrejas.domain.model;

import java.util.List;

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
@Table(name = "filho")

public class FilhoModel {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;
	private String nome;
	private String celular;
	
	@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinTable(
    name = "filho_alergias", 
    joinColumns = @JoinColumn(name = "filho_id"), 
    inverseJoinColumns = @JoinColumn(name = "alergia_id"))
	private List<AlergiaModel> alergias;
	
	@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinTable(
    name = "filho_restricoes", 
    joinColumns = @JoinColumn(name = "filho_id"), 
    inverseJoinColumns = @JoinColumn(name = "restricao_id"))
	private List<RestricaoModel> restricoes;
	
	@Column(name="pai_id")
	private Long responsavelId;
	
	
	
}
