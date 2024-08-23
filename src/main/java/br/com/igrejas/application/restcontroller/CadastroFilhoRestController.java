package br.com.igrejas.application.restcontroller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
import br.com.igrejas.domain.dto.FilhoDTO;
import br.com.igrejas.domain.model.FilhoModel;
import br.com.igrejas.domain.service.FilhoService;

@RestController
@RequestMapping("/api/v1/cadastro-filho")
public class CadastroFilhoRestController {

	
	@Autowired
	private FilhoService service;
	
	@GetMapping("/responsavel/{responsavelId}")
	public @ResponseBody List<FilhoDTO> listaFilhos(@PathVariable Long responsavelId){
		List<FilhoModel> filho = service.listarTodos(responsavelId);
		return filho.stream()
		          .map(ConverterDataUtil::converteFilhoEntityToDTO)
		          .collect(Collectors.toList());
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void incluirFilho(@RequestBody FilhoDTO filhoDTO) {
		//filhoDTO.getAlergias().forEach(alergia-> System.out.println(alergia.getDescricaoAlergia()));
		service.salvar(ConverterDataUtil.converteFilhoDTOToEntity(filhoDTO));
	}
	
	
	@GetMapping("/{id}")
	public @ResponseBody FilhoDTO procurarPorId(@PathVariable("id") Long id){
		return ConverterDataUtil.converteFilhoEntityToDTO(service.procurarPorId(id));
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletarFilho(@PathVariable("id") Long id){
		service.excluir(id);
	}
	
	
}
