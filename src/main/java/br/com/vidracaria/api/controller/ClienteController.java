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

import br.com.vidracaria.domain.model.Cliente;
import br.com.vidracaria.domain.repository.ClienteRepository;
import br.com.vidracaria.domain.service.ClienteService;

@CrossOrigin(origins = "https://app-receitadespesa.herokuapp.com")
@RequestMapping("/clientes")
@RestController
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Cliente salvar(@Valid @RequestBody Cliente cliente) {
		return clienteService.salvar(cliente);
	}
	
	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	public List<Cliente> buscarTodos() {
		return clienteService.buscarTodos();
	}
	
//	@GetMapping
//	@ResponseStatus(code = HttpStatus.OK)
//	public Page<Cliente> buscarTodos() {
//		return clienteService.buscarTodosComPagina();
//	}
	
	@PutMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public Cliente atualizar(@RequestBody Cliente cliente, @PathVariable Long id) {
		Cliente clienteBanco = clienteService.buscarPorId(id);
		
		clienteBanco.setNome(cliente.getNome());
		clienteBanco.setCpf(cliente.getCpf());
		clienteBanco.setEndereco(cliente.getEndereco());
		
		return clienteService.salvar(clienteBanco);
	}
	
	@GetMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public Cliente buscarPorId(@PathVariable Long id) {
		return clienteService.buscarPorId(id);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		clienteService.delete(id);
	}

}
