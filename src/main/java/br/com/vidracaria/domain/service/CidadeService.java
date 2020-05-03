package br.com.vidracaria.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vidracaria.domain.model.Cidade;
import br.com.vidracaria.domain.repository.CidadeRepository;

@Service
public class CidadeService {

	@Autowired
	private CidadeRepository cidadeRepository;
	
	public Cidade salvar(Cidade cidade) {
		return this.cidadeRepository.save(cidade);
	}
	
	public List<Cidade> buscarTodas() {
		return this.cidadeRepository.findAll();
	}
	
	public void delete(Long id) {
		this.cidadeRepository.deleteById(id);
	}

	public Cidade buscarPorId(Long id) {
		return this.cidadeRepository.findById(id).get();
	}
	
	public List<Cidade> buscarPeloEstado(Long id) {
		return this.cidadeRepository.findByEstadoId(id);
	}
	
	public Cidade buscarPorNome(String nomeCidade, String siglaEstado) {
		return this.cidadeRepository.findByNomeStartingWithIgnoreCaseAndEstadoSigla(nomeCidade, siglaEstado);
	}
}
