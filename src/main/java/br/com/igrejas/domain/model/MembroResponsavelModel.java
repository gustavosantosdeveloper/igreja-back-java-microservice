package br.com.igrejas.domain.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="MEMBRO_RESPONSAVEL")
@Data
public class MembroResponsavelModel {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;
	private String nome;
	private String cpf;
	private String logradouro;
	private String bairro;
	private String cep;
	private String estado;
	private String cidade;
	private String pais;
	private String telefone;
	private String email;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "pai_id", referencedColumnName = "id")
	private List<FilhoModel> filhos;
	
	
}
