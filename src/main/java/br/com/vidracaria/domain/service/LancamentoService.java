package br.com.vidracaria.domain.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vidracaria.domain.model.Cliente;
import br.com.vidracaria.domain.model.Lancamento;
import br.com.vidracaria.domain.repository.LancamentoRepository;

@Service
public class LancamentoService {

	@Autowired
	private LancamentoRepository lancamentoRepository;
	
	public Lancamento salvar(Lancamento lancamento) {
		lancamento.setDataLancamento(LocalDate.now());
		return this.lancamentoRepository.save(lancamento);
	}
	
	public List<Lancamento> buscarTodos() {
		return this.lancamentoRepository.findAll();
	}
	
	public Lancamento buscarPorId(Long id) {
		return lancamentoRepository.findById(id).get();
	}
}
