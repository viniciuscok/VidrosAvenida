package br.com.vidracaria.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vidracaria.domain.model.Receita;
import br.com.vidracaria.domain.repository.ReceitaRepository;

@Service
public class ReceitaService {

	@Autowired
	private ReceitaRepository receitaRepository;
	
	public Receita salvar(Receita receita) {
		return this.receitaRepository.save(receita);
	}
	
	public List<Receita> buscarTodas() {
		return this.receitaRepository.findAll();
	}
	
	public void delete(Long id) {
		this.receitaRepository.deleteById(id);
	}

	public Receita buscarPorId(Long id) {
		return this.receitaRepository.findById(id).get();
	}
}
