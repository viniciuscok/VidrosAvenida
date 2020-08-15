package br.com.vidracaria.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vidracaria.domain.model.SubCategoria;
import br.com.vidracaria.domain.repository.SubCategoriaRepository;

@Service
public class SubCategoriaService {

	@Autowired
	private SubCategoriaRepository subSubCategoriaRepository;
	
	public SubCategoria salvar(SubCategoria subSubCategoria) {
		return this.subSubCategoriaRepository.save(subSubCategoria);
	}
	
	public List<SubCategoria> buscarTodas() {
		return this.subSubCategoriaRepository.findAll();
	}
	
	public void delete(Long id) {
		this.subSubCategoriaRepository.deleteById(id);
	}

	public SubCategoria buscarPorId(Long id) {
		return this.subSubCategoriaRepository.findById(id).get();
	}
	
}
