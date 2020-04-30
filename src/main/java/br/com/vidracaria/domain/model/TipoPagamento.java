package br.com.vidracaria.domain.model;

public enum TipoPagamento {
	
	CREDITO("Crédito"),
	DEBITO("Débito");
	
	private String descricao;
	
	private TipoPagamento(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
	
	

}
