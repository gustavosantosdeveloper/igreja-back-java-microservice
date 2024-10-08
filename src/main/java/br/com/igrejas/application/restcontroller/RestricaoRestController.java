package br.com.igrejas.application.restcontroller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
import br.com.igrejas.domain.dto.RestricaoDTO;
import br.com.igrejas.domain.service.RestricaoService;

@RestController
@RequestMapping("/api/v1/cadastro-restricao")
public class RestricaoRestController {

	@Autowired
	private RestricaoService service;
	
	@GetMapping
	public @ResponseBody List<RestricaoDTO> listarTodas(){
		return service.listarTodos().stream()
		          .map(ConverterDataUtil::converteRestricaoEntityToDTO)
		          .collect(Collectors.toList());
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void incluirRestricao(@RequestBody RestricaoDTO dto) {
		service.incluir(ConverterDataUtil.converteRestricaiDTOToEntity(dto));
	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void alterarRestricao(@PathVariable("id") Long id, @RequestBody RestricaoDTO dto) {
		service.alterar(id,(dto));
	}
	
	@GetMapping("/{id}")
	public @ResponseBody RestricaoDTO procurarPorId(@PathVariable("id") Long id){
		return ConverterDataUtil.converteRestricaoEntityToDTO(service.procurarPorId(id));
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletarRestricao(@PathVariable("id") Long id){
		service.deletar(id);
	}	

	
}
