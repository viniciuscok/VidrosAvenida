package br.com.vidracaria.api.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.vidracaria.api.model.FotoProdutoModel;
import br.com.vidracaria.domain.model.FotoProduto;

@Component
public class FotoProdutoModelAssembler {
	@Autowired
	private ModelMapper modelMapper;
	
	public FotoProdutoModel toModel(FotoProduto foto) {
		return modelMapper.map(foto, FotoProdutoModel.class);
	}
	
}
