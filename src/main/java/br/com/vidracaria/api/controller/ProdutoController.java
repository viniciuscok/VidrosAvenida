package br.com.vidracaria.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.vidracaria.domain.model.Produto;
import br.com.vidracaria.domain.service.ProdutoService;

@CrossOrigin
@RestController
@RequestMapping("/produtos")
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Produto salvar(@RequestBody Produto produto) {
		
		return produtoService.salvar(produto);
	}
	
	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	public List<Produto> buscarTodos() {
		
		return produtoService.buscarTodos();
	}
}
