package br.com.vidracaria.api.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

import br.com.vidracaria.domain.model.Estado;
import br.com.vidracaria.domain.repository.EstadoRepository;
import br.com.vidracaria.domain.service.EstadoService;

@CrossOrigin(origins = "*")
@RequestMapping("/estados")
@RestController
public class EstadoController {
	
	@Autowired
	private EstadoService estadoService;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Estado salvar(@Valid @RequestBody Estado estado) {
		return estadoService.salvar(estado);
	}
	
	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	public List<Estado> buscarTodos() {
		return estadoService.buscarTodos();
	}
	
//	@GetMapping
//	@ResponseStatus(code = HttpStatus.OK)
//	public Page<Estado> buscarTodos() {
//		return estadoService.buscarTodosComPagina();
//	}
	
	@PutMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public Estado atualizar(@RequestBody Estado estado, @PathVariable Long id) {
		Estado estadoBanco = estadoService.buscarPorId(id);
		
		estadoBanco.setNome(estado.getNome());
		estadoBanco.setSigla(estado.getSigla());
		
		return estadoService.salvar(estadoBanco);
	}
	
//	@GetMapping("/{id}")
//	@ResponseStatus(code = HttpStatus.OK)
//	public Estado buscarPorId(@PathVariable Long id) {
//		return estadoService.buscarPorId(id);
//	}
	
	@GetMapping("/{sigla}")
	@ResponseStatus(code = HttpStatus.OK)
	public Estado buscarPorSigla(@PathVariable String sigla) {
		return estadoService.buscarPorSigla(sigla);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		estadoService.delete(id);
	}

}
