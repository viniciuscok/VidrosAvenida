package br.com.vidracaria.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.vidracaria.domain.model.Cliente;
import br.com.vidracaria.domain.model.Lancamento;
import br.com.vidracaria.domain.service.LancamentoService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/lancamentos")
public class LancamentoController {
	
	@Autowired
	private LancamentoService lancamentoService;
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Lancamento salvar(@Valid @RequestBody Lancamento lancamento) {
		return this.lancamentoService.salvar(lancamento);
	}
	
	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	public List<Lancamento> buscarTodos() {
		return this.lancamentoService.buscarTodos();
	}
	
	@GetMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public Lancamento buscarPorId(@PathVariable Long id) {
		return lancamentoService.buscarPorId(id);
	}
	
	@PutMapping
	@ResponseStatus(code = HttpStatus.OK)
	public Lancamento atualizar(@Valid @RequestBody Lancamento lancamento, @PathVariable Long id) {
		Lancamento lancamentoBanco = this.lancamentoService.buscarPorId(id);
		lancamentoBanco.setDescricao(lancamento.getDescricao());
		lancamentoBanco.setCliente(lancamento.getCliente());
		lancamentoBanco.setCategoria(lancamento.getCategoria());
		lancamentoBanco.setTipoLancamento(lancamento.getTipoLancamento());
		
		return this.lancamentoService.salvar(lancamentoBanco);
	}

}
