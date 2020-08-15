package br.com.vidracaria.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.vidracaria.domain.model.FotoProduto;
import br.com.vidracaria.domain.repository.ProdutoRepository;

@Service
public class FotoProdutoService {
	
	@Autowired
	private ProdutoRepository produtoRepository;

	@Transactional
	public FotoProduto salvar(FotoProduto foto) {
		return produtoRepository.save(foto);
	}
}
