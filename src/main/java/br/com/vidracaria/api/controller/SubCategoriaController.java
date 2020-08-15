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

import br.com.vidracaria.domain.model.SubCategoria;
import br.com.vidracaria.domain.service.SubCategoriaService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/subCategorias")
public class SubCategoriaController {
	
	@Autowired
	private SubCategoriaService subCategoriaService;
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public SubCategoria salvar(@Valid @RequestBody SubCategoria subCategoria) {
		return this.subCategoriaService.salvar(subCategoria);
	}
	
	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	public List<SubCategoria> buscarTodas() {
		return this.subCategoriaService.buscarTodas();
	}
	
//	@GetMapping("/despesas")
//	@ResponseStatus(code = HttpStatus.OK)
//	public List<SubCategoria> buscarDespesa() {
//		return this.subCategoriaService.buscarDespesa();
//	}
//	
//	@GetMapping("/receitas")
//	@ResponseStatus(code = HttpStatus.OK)
//	public List<SubCategoria> buscarReceita() {
//		return this.subCategoriaService.buscarReceita();
//	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public void delete(@PathVariable Long id) {
		this.subCategoriaService.delete(id);
	}
	
	@GetMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public SubCategoria buscarPorId(@PathVariable Long id) {
		return this.subCategoriaService.buscarPorId(id);
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public SubCategoria atualizar(@RequestBody SubCategoria subCategoria, @PathVariable Long id) {
		SubCategoria subCategoriaBanco = this.subCategoriaService.buscarPorId(id);
		subCategoriaBanco.setNome(subCategoria.getNome());
		subCategoriaBanco.setObservacao(subCategoria.getObservacao());
		
		return this.subCategoriaService.salvar(subCategoriaBanco);
	}
}
