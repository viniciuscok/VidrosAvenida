package br.com.vidracaria.api.controller;

import java.util.List;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.vidracaria.domain.model.Cidade;
import br.com.vidracaria.domain.service.CidadeService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/cidades")
public class CidadeController {
	
	@Autowired
	private CidadeService cidadeService;
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Cidade salvar(@Valid @RequestBody Cidade cidade) {
		return this.cidadeService.salvar(cidade);
	}
	
	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	public List<Cidade> buscarTodas() {
		return this.cidadeService.buscarTodas();
	}
	
	
	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public void delete(@PathVariable Long id) {
		this.cidadeService.delete(id);
	}
	
	@GetMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public List<Cidade> tesbuscarPorId(@PathVariable Long id) {
		return this.cidadeService.buscarPeloEstado(id);
	}
	
	@GetMapping("/{siglaEstado}/{nomeCidade}")
	@ResponseStatus(code = HttpStatus.OK)
	public Cidade buscarPorNome(@PathVariable String nomeCidade, @PathVariable String siglaEstado) {
		return this.cidadeService.buscarPorNome(nomeCidade, siglaEstado);
	}
	
	
//	@PutMapping("/{id}")
//	@ResponseStatus(code = HttpStatus.OK)
//	public Cidade atualizar(@RequestBody Cidade cidade, @PathVariable Long id) {
//		Cidade cidadeBanco = this.cidadeService.buscarPorId(id);
//		cidadeBanco.setNome(cidade.getNome());
//		cidadeBanco.setTipoCidade(cidade.getTipoCidade());
//		cidadeBanco.setObservaçao(cidade.getObservaçao());
//		
//		return this.cidadeService.salvar(cidadeBanco);
//	}
	
	
	

}
