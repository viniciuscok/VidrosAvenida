package br.com.vidracaria.domain.model;

import javax.persistence.Embeddable;

import lombok.Data;

@Embeddable
@Data
public class Endereco {
	private String logradouro;
	private String numero;
	private String cep;
	private String bairro;
	private String Cidade;
	private String estado;

}
