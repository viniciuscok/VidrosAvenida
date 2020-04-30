package br.com.vidracaria.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.vidracaria.domain.model.Cliente;
import br.com.vidracaria.domain.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	public Cliente salvar(Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
	public List<Cliente> buscarTodos() {
		return clienteRepository.findAll();
	}
	
	public Cliente buscarPorId(Long id) {
		return clienteRepository.findById(id).get();
	}
	
	public void delete(Long id) {
		clienteRepository.deleteById(id);
	}
	
	public Page<Cliente> buscarTodosComPagina() {
		int page = 0;
		int size =10;
		PageRequest pageRequest = PageRequest.of(page, size, Sort.Direction.ASC, "nome");
		return new PageImpl(clienteRepository.findAll(), pageRequest, size);
	}
}
