package br.com.vidracaria.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "foto_produto")
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FotoProduto {
	
	@Id
	@Column(name = "produto_id")
	Long id;
	String nomeArquivo;
	String descricao;
	String contentType;
	Long tamanho;
	
	@OneToOne
	@MapsId
	Produto produto;

}
