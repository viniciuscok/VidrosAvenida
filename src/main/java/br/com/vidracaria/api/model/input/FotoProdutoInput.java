package br.com.vidracaria.api.model.input;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FotoProdutoInput {
	@NotNull
	private MultipartFile arquivo;
	
	@NotBlank
	private String descricao;
}
