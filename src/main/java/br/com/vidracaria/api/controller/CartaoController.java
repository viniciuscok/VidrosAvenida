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

import br.com.vidracaria.domain.model.Cartao;
import br.com.vidracaria.domain.model.TipoPagamento;
import br.com.vidracaria.domain.service.CartaoService;

@CrossOrigin
@RestController
@RequestMapping("/cartoes")
public class CartaoController {

	@Autowired
	private CartaoService cartaoService;
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Cartao salvar(@RequestBody Cartao cartao) {
		
		return cartaoService.salvar(cartao);
	}
	
	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	public List<Cartao> buscarTodos() {
		
		return cartaoService.buscarTodos();
	}
	
	@GetMapping("/tiposPagamentos")
	public TipoPagamento[] tiposPagamentos() {
		return TipoPagamento.values();
	}
}
