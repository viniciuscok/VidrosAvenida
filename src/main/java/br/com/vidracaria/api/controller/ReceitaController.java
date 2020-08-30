package br.com.vidracaria.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.vidracaria.domain.model.Receita;
import br.com.vidracaria.domain.service.ReceitaService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/receitas")
public class ReceitaController {
	
	@Autowired
	private ReceitaService receitaService;
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Receita salvar(@Valid @RequestBody Receita receita) {
		return this.receitaService.salvar(receita);
	}
	
	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	public List<Receita> buscarTodas() {
		return this.receitaService.buscarTodas();
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public void delete(@PathVariable Long id) {
		this.receitaService.delete(id);
	}
	
	@GetMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public Receita buscarPorId(@PathVariable Long id) {
		return this.receitaService.buscarPorId(id);
	}
	
	@GetMapping("/valorTotal")
	@ResponseStatus(code = HttpStatus.OK)
	public int buscarValorTotal() {
		return this.receitaService.buscarValor();
	}
	
	@GetMapping("/saldoTotal")
	@ResponseStatus(code = HttpStatus.OK)
	public int buscarSaldoTotal() {
		return this.receitaService.totaldespesaReceita();
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public Receita atualizar(@RequestBody Receita receita, @PathVariable Long id) {
		Receita receitaBanco = this.receitaService.buscarPorId(id);
		receitaBanco.setDataRecebimento(receita.getDataRecebimento());
		receitaBanco.setDescricao(receita.getDescricao());
		receitaBanco.setValor(receita.getValor());
		receitaBanco.setObservacao(receita.getObservacao());
		receitaBanco.setCategoria(receita.getCategoria());
		receitaBanco.setCliente(receita.getCliente());
		
		return this.receitaService.salvar(receitaBanco);
	}

}
