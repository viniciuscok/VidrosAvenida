package br.com.vidracaria.api.controller;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.UUID;

import javax.mail.Multipart;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.com.vidracaria.api.assembler.FotoProdutoModelAssembler;
import br.com.vidracaria.api.model.FotoProdutoModel;
import br.com.vidracaria.api.model.input.FotoProdutoInput;
import br.com.vidracaria.domain.model.FotoProduto;
import br.com.vidracaria.domain.model.Produto;
import br.com.vidracaria.domain.service.FotoProdutoService;
import br.com.vidracaria.domain.service.ProdutoService;

@CrossOrigin
@RestController
@RequestMapping("/produtos")
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;
	
	@Autowired
	private FotoProdutoService fotoProdutoService;
	
	@Autowired
	private FotoProdutoModelAssembler fotoProdutoModelAssembler;
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Produto salvar(@RequestBody Produto produto) {
		
		return produtoService.salvar(produto);
	}
	
	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	public List<Produto> buscarTodos() {
		
		return produtoService.buscarTodos();
	}
	
	@PutMapping(value = "/{produtoId}/foto", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public FotoProdutoModel atualizarFoto(@PathVariable Long produtoId, @Valid FotoProdutoInput fotoProdutoInput) {
//		var nomeArquivo = UUID.randomUUID().toString() + "_" + arquivo.getOriginalFilename();
//		
//		var aquivoFoto = Path.of("E:\\PROGRAMAS DESENVOLVIDOS\\VINICIUS\\VIDRACARIA\\ARQUIVOS\\foto", nomeArquivo);
//		
//		
//		try {
//			arquivo.transferTo(aquivoFoto);
//		} catch (Exception e) {
//			throw new RuntimeException(e);
//		}
		Produto produto = produtoService.buscarPorId(produtoId);
		
		FotoProduto foto = new FotoProduto();
		foto.setProduto(produto);
		foto.setDescricao(fotoProdutoInput.getDescricao());
		foto.setContentType(fotoProdutoInput.getArquivo().getContentType());
		foto.setTamanho(fotoProdutoInput.getArquivo().getSize());
		foto.setNomeArquivo(fotoProdutoInput.getArquivo().getOriginalFilename());

		FotoProduto fotoSalva = fotoProdutoService.salvar(foto);
		
		return fotoProdutoModelAssembler.toModel(fotoSalva);
	}
}
