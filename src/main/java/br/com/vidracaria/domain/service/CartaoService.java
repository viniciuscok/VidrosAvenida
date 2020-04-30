package br.com.vidracaria.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vidracaria.domain.model.Cartao;
import br.com.vidracaria.domain.repository.CartaoRepository;

@Service
public class CartaoService {
	
	@Autowired
	private CartaoRepository cartaoRepository;
	
	public Cartao salvar(Cartao cartao) {
		return cartaoRepository.save(cartao);
	}
	
	public List<Cartao> buscarTodos() {
		return cartaoRepository.findAll();
	}
	
	public Cartao buscarPorId(Long id) {
		return cartaoRepository.findById(id).get();
	}
}
