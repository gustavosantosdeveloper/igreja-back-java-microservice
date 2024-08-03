package br.com.igrejas.application.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.igrejas.domain.builder.ConverterDataUtil;
import br.com.igrejas.domain.dto.MembroResponsavelDTO;
import br.com.igrejas.domain.exceptions.MembroNotFoundException;
import br.com.igrejas.domain.service.MembroResponsavelService;

@RestController
@RequestMapping("/cadastro-usuario")
@CrossOrigin("*")
public class CadastroMembroRestController {

	@Autowired
	private MembroResponsavelService service;
	
	@GetMapping
	public @ResponseBody List<MembroResponsavelDTO> listarMembros(){
		return service.listarTodos();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void incluirMembro(@RequestBody MembroResponsavelDTO membroResponsavelDTO) {
		service.salvar(membroResponsavelDTO);
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void alterarMembro(@PathVariable Long id,@RequestBody MembroResponsavelDTO membroResponsavelDTO) throws MembroNotFoundException {
		service.alterar(id, membroResponsavelDTO);
	}
	
	
	@GetMapping("/{id}")
	public @ResponseBody MembroResponsavelDTO procurarPorId(@PathVariable("id") Long id) throws MembroNotFoundException{
		return service.procurarPorId(id);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletarUsuario(@PathVariable("id") Long id){
		service.excluir(id);
	}
	
	
	
}
