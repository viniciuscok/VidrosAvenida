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

import br.com.vidracaria.domain.model.Despesa;
import br.com.vidracaria.domain.service.DespesaService;
//https://app-receitadespesa.herokuapp.com
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/despesas")
public class DespesaController {
	
	@Autowired
	private DespesaService despesaService;
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Despesa salvar(@Valid @RequestBody Despesa despesa) {
		return this.despesaService.salvar(despesa);
	}
	
	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	public List<Despesa> buscarTodas() {
		return this.despesaService.buscarTodas();
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public void delete(@PathVariable Long id) {
		this.despesaService.delete(id);
	}
	
	@GetMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public Despesa buscarPorId(@PathVariable Long id) {
		return this.despesaService.buscarPorId(id);
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public Despesa atualizar(@RequestBody Despesa despesa, @PathVariable Long id) {
		Despesa despesaBanco = this.despesaService.buscarPorId(id);
		despesaBanco.setDataLancamento(despesa.getDataLancamento());
		despesaBanco.setDataPagamento(despesa.getDataPagamento());
		despesaBanco.setDescricao(despesa.getDescricao());
		despesaBanco.setValor(despesa.getValor());
		despesaBanco.setObservacao(despesa.getObservacao());
		despesaBanco.setCategoria(despesa.getCategoria());
		despesaBanco.setCliente(despesa.getCliente());
		
		
		return this.despesaService.salvar(despesaBanco);
	}

}
