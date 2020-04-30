package br.com.vidracaria.domain.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vidracaria.domain.model.Despesa;
import br.com.vidracaria.domain.repository.DespesaRepository;

@Service
public class DespesaService {

	@Autowired
	private DespesaRepository despesaRepository;
	
	public Despesa salvar(Despesa despesa) {
		if(despesa.getId() == null) {
			despesa.setDataLancamento(LocalDate.now());			
		}
		return this.despesaRepository.save(despesa);
	}
	
	public List<Despesa> buscarTodas() {
		return this.despesaRepository.findAll();
	}
	
	public void delete(Long id) {
		this.despesaRepository.deleteById(id);
	}

	public Despesa buscarPorId(Long id) {
		return this.despesaRepository.findById(id).get();
	}
}
