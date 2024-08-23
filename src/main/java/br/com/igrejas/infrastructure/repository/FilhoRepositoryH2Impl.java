package br.com.igrejas.infrastructure.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

import br.com.igrejas.domain.model.AlergiaModel;
import br.com.igrejas.domain.model.FilhoModel;
import br.com.igrejas.domain.model.RestricaoModel;
import br.com.igrejas.domain.repository.FilhoRepositoryInterface;

public class FilhoRepositoryH2Impl implements FilhoRepositoryInterface {

	@Autowired
	@Lazy
	private FilhoRepositoryH2 filhoRepositoryH2;
	
	@Autowired
	private AlergiaRepositoryH2 alergiaRepository;

	@Autowired
	private RestricaoRepositoryH2 restricaoRepository;
	
	
	@Override
	public List<FilhoModel> listarTodos(Long responsavelId) {
		List<FilhoModel> result = new ArrayList<FilhoModel>();
		filhoRepositoryH2.findByResponsavelId(responsavelId).forEach(result::add);
		return result;
	}

	@Override
	public void salvar(FilhoModel filho) {
		List<AlergiaModel> listaAlergias = new ArrayList<>();
		if (filho.getAlergias()!=null && !filho.getAlergias().isEmpty()) {
			filho.getAlergias().forEach(alergia -> {
				listaAlergias.add(alergiaRepository.findById(alergia.getId()).orElse(null));	
			});
		}
		List<RestricaoModel> listaRestricoes = new ArrayList<>();
		if (filho.getRestricoes()!=null && !filho.getRestricoes().isEmpty()) {
			filho.getRestricoes().forEach(restricao -> {
				listaRestricoes.add(restricaoRepository.findById(restricao.getId()).orElse(null));	
			});
		}
		filho.setAlergias(listaAlergias);
		filho.setRestricoes(listaRestricoes);
		filhoRepositoryH2.save(filho);
		
		/*
		 * filho = filhoRepositoryH2.save(filho); Set<FilhoModel> filhos = new
		 * HashSet<>(); filhos.add(filho); listaAlergias.addAll(filho.getAlergias());
		 * listaAlergias.forEach(alergia->{ alergia.setFilhos(filhos); });
		 * alergiaRepository.saveAll(listaAlergias);
		 * 
		 * listaRestricoes.addAll(filho.getRestricoes());
		 * listaRestricoes.forEach(restricao->{ restricao.setFilhos(filhos); });
		 * restricaoRepository.saveAll(listaRestricoes);
		 */
		
	}	
	@Override
	public void excluir(Long id) {
		filhoRepositoryH2.deleteById(id);
	}

	@Override
	public FilhoModel procurarPorId(Long id) {
		return filhoRepositoryH2.findById(id).orElse(null);
	}

}
