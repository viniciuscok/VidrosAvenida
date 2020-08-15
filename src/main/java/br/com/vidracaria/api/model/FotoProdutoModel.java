package br.com.vidracaria.api.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FotoProdutoModel {
	String nomeArquivo;
	String descricao;
	String contentType;
	Long tamanho;
}
