package br.com.vidracaria.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vidracaria.domain.model.Categoria;
import br.com.vidracaria.domain.repository.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public Categoria salvar(Categoria categoria) {
		return this.categoriaRepository.save(categoria);
	}
	
	public List<Categoria> buscarTodas() {
		return this.categoriaRepository.findAll();
	}
	
	public void delete(Long id) {
		this.categoriaRepository.deleteById(id);
	}

	public Categoria buscarPorId(Long id) {
		return this.categoriaRepository.findById(id).get();
	}
	
	public List<Categoria> buscarDespesa() {
		return this.categoriaRepository.buscarDespesa();
	}
	
	public List<Categoria> buscarReceita() {
		return this.categoriaRepository.buscarReceita();
	}
}
