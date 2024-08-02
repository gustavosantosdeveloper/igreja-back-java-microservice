package br.com.igrejas.domain.builder;

import org.modelmapper.ModelMapper;

import br.com.igrejas.domain.dto.AlergiaDTO;
import br.com.igrejas.domain.dto.FilhoDTO;
import br.com.igrejas.domain.dto.MembroResponsavelDTO;
import br.com.igrejas.domain.dto.RestricaoDTO;
import br.com.igrejas.domain.model.AlergiaModel;
import br.com.igrejas.domain.model.FilhoModel;
import br.com.igrejas.domain.model.MembroResponsavelModel;
import br.com.igrejas.domain.model.RestricaoModel;

public class ConverterDataUtil {

	public static MembroResponsavelDTO converteMembroEntityToDTO(MembroResponsavelModel membro) {
		ModelMapper modelMapper = new ModelMapper();
		return membro==null?null: modelMapper.map(membro, MembroResponsavelDTO.class);
	    
	}

	public static MembroResponsavelModel converteMembroDTOToEntity(MembroResponsavelDTO dto) {
		ModelMapper modelMapper = new ModelMapper();
		return dto ==null ? null : modelMapper.map(dto, MembroResponsavelModel.class);
	}

	public static FilhoDTO converteFilhoEntityToDTO(FilhoModel filho) {
		ModelMapper modelMapper = new ModelMapper();
		return filho==null?null: modelMapper.map(filho, FilhoDTO.class);
	    
	}

	public static FilhoModel converteFilhoDTOToEntity(FilhoDTO dto) {
		ModelMapper modelMapper = new ModelMapper();
		return dto ==null ? null : modelMapper.map(dto, FilhoModel.class);
	}
	
	public static AlergiaModel converteAlergiaDTOToEntity(AlergiaDTO dto) {
		ModelMapper modelMapper = new ModelMapper();
		return dto ==null ? null : modelMapper.map(dto, AlergiaModel.class);
	}
	
	public static AlergiaDTO converteAlergiEntityToDTO(AlergiaModel model) {
		ModelMapper modelMapper = new ModelMapper();
		return model ==null ? null : modelMapper.map(model, AlergiaDTO.class);
	}
	
	public static RestricaoModel converteRestricaiDTOToEntity(RestricaoDTO dto) {
		ModelMapper modelMapper = new ModelMapper();
		return dto ==null ? null : modelMapper.map(dto, RestricaoModel.class);
	}
	
	public static RestricaoDTO converteRestricaoEntityToDTO(RestricaoModel model) {
		ModelMapper modelMapper = new ModelMapper();
		return model ==null ? null : modelMapper.map(model, RestricaoDTO.class);
	}
	
	
}
