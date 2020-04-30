package br.com.vidracaria.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.vidracaria.domain.model.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long>{
	
	@Query(value = "FROM Categoria where tipoCategoria='DESPESA' or tipoCategoria='RECEITA_DESPESA'")
	List<Categoria>  buscarDespesa();
	
	@Query(value = "FROM Categoria where tipoCategoria='RECEITA' or tipoCategoria='RECEITA_DESPESA'")
	List<Categoria>  buscarReceita();

}
