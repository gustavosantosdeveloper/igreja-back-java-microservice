package br.com.igrejas.application.restcontroller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.igrejas.domain.builder.ConverterDataUtil;
import br.com.igrejas.domain.dto.MembroResponsavelDTO;
import br.com.igrejas.domain.service.MembroResponsavelService;

@RestController
@RequestMapping("/cadastro-usuario")
@CrossOrigin("*")
public class CadastroMembroRestController {

	@Autowired
	private MembroResponsavelService service;
	
	@GetMapping
	public @ResponseBody List<MembroResponsavelDTO> listarMembros(){
		return service.listarTodos().stream()
		          .map(ConverterDataUtil::converteMembroEntityToDTO)
		          .collect(Collectors.toList());
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void incluirMembro(@RequestBody MembroResponsavelDTO membroResponsavelDTO) {
		service.salvar(ConverterDataUtil.converteMembroDTOToEntity(membroResponsavelDTO));
	}
	
	
	@GetMapping("/{id}")
	public @ResponseBody MembroResponsavelDTO procurarPorId(@PathVariable("id") Long id){
		return ConverterDataUtil.converteMembroEntityToDTO(service.procurarPorId(id));
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletarUsuario(@PathVariable("id") Long id){
		service.excluir(id);
	}
	
	
	
}
