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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.igrejas.domain.builder.ConverterDataUtil;
import br.com.igrejas.domain.dto.AlergiaDTO;
import br.com.igrejas.domain.service.AlergiaService;

@RestController
@RequestMapping("/cadastro-alergia")
@CrossOrigin("*")
public class AlergiaRestController {

	@Autowired
	private AlergiaService service;
	
	@GetMapping
	public @ResponseBody List<AlergiaDTO> listarTodas(){
		return service.listarTodos().stream()
		          .map(ConverterDataUtil::converteAlergiEntityToDTO)
		          .collect(Collectors.toList());
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void incluirAlergia(@RequestBody AlergiaDTO dto) {
		service.incluir(ConverterDataUtil.converteAlergiaDTOToEntity(dto));
	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void alterarrAlergia(@PathVariable("id") Long id, @RequestBody AlergiaDTO dto) {
		service.alterar(id,(dto));
	}
	
	@GetMapping("/{id}")
	public @ResponseBody AlergiaDTO procurarPorId(@PathVariable("id") Long id){
		return ConverterDataUtil.converteAlergiEntityToDTO(service.procurarPorId(id));
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletarAlergia(@PathVariable("id") Long id){
		service.excluir(id);
	}	
	
}
