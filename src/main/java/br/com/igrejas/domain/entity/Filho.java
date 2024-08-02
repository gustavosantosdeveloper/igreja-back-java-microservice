package br.com.igrejas.domain.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "filho")
public class Filho {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;
	private String nome;
	private String celular;
	private List<Alergia> alergias;
	private List<Restricao> restricoes;
	@Column(name="responsavel_id")
	private Long responsavelId;
	
	
	
}
