package br.com.vidracaria.domain.model;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Embeddable
@Data
public class Endereco {
	private String logradouro;
	private String numero;
	private String complemento;
	private String cep;
	private String bairro;
	
	@ManyToOne
	@JoinColumn(name = "id_cidade")
	private Cidade Cidade;
	
	@ManyToOne
	@JoinColumn(name = "id_estado")
	private Estado estado;

}
