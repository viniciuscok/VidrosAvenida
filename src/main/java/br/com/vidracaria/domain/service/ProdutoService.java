package br.com.vidracaria.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vidracaria.domain.model.Produto;
import br.com.vidracaria.domain.repository.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	public Produto salvar(Produto produto) {
		return produtoRepository.save(produto); 
	}
	
	public List<Produto> buscarTodos() {
		return produtoRepository.findAll();
	}
	
	public Produto buscarPorId(Long produtoId) {
		return produtoRepository.findById(produtoId).orElseThrow(() -> new RuntimeException("não foi possível encontrar o produto"));
	}

}
