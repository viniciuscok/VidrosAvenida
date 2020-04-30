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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.vidracaria.domain.model.Categoria;
import br.com.vidracaria.domain.model.TipoCategoria;
import br.com.vidracaria.domain.service.CategoriaService;

@CrossOrigin(origins = "http://localhost:4201,https://app-receitadespesa.herokuapp.com")
@RestController
@RequestMapping("/categorias")
public class CategoriaController {
	
	@Autowired
	private CategoriaService categoriaService;
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Categoria salvar(@Valid @RequestBody Categoria categoria) {
		return this.categoriaService.salvar(categoria);
	}
	
	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	public List<Categoria> buscarTodas() {
		return this.categoriaService.buscarTodas();
	}
	
	@GetMapping("/despesas")
	@ResponseStatus(code = HttpStatus.OK)
	public List<Categoria> buscarDespesa() {
		return this.categoriaService.buscarDespesa();
	}
	
	@GetMapping("/receitas")
	@ResponseStatus(code = HttpStatus.OK)
	public List<Categoria> buscarReceita() {
		return this.categoriaService.buscarReceita();
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public void delete(@PathVariable Long id) {
		this.categoriaService.delete(id);
	}
	
	@GetMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public Categoria buscarPorId(@PathVariable Long id) {
		return this.categoriaService.buscarPorId(id);
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public Categoria atualizar(@RequestBody Categoria categoria, @PathVariable Long id) {
		Categoria categoriaBanco = this.categoriaService.buscarPorId(id);
		categoriaBanco.setNome(categoria.getNome());
		categoriaBanco.setTipoCategoria(categoria.getTipoCategoria());
		categoriaBanco.setObservaçao(categoria.getObservaçao());
		
		return this.categoriaService.salvar(categoriaBanco);
	}
	
	@GetMapping("/tipoCategorias")
	@ResponseStatus(code = HttpStatus.OK)
	public TipoCategoria[] buscarTipoCategoria() {
		return TipoCategoria.values();
	}
	
	

}
