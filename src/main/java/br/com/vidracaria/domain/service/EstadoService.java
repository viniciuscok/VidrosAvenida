package br.com.vidracaria.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.vidracaria.domain.model.Estado;
import br.com.vidracaria.domain.repository.EstadoRepository;

@Service
public class EstadoService {

	@Autowired
	private EstadoRepository estadoRepository;
	
	public Estado salvar(Estado estado) {
		return estadoRepository.save(estado);
	}
	
	public List<Estado> buscarTodos() {
		return estadoRepository.findAll();
	}
	
	public Estado buscarPorId(Long id) {
		return estadoRepository.findById(id).get();
	}
	
	public Estado buscarPorSigla(String sigla) {
		return estadoRepository.findBySigla(sigla);
	}
	
	public void delete(Long id) {
		estadoRepository.deleteById(id);
	}
	
	public Page<Estado> buscarTodosComPagina() {
		int page = 0;
		int size =10;
		PageRequest pageRequest = PageRequest.of(page, size, Sort.Direction.ASC, "nome");
		return new PageImpl(estadoRepository.findAll(), pageRequest, size);
	}
}
