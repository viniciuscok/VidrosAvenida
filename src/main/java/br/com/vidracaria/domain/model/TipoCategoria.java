package br.com.vidracaria.domain.model;

import lombok.Getter;

@Getter
public enum TipoCategoria {
	
	RECEITA("Receita"),
	DESPESA("Despesa"),
	RECEITA_DESPESA("Receita/Despesa");
	
	private String descricao;
	
	private TipoCategoria(String descricao) {
		this.descricao = descricao;
	}

}
