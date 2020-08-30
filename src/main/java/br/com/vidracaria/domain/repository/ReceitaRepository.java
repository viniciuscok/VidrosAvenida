package br.com.vidracaria.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.vidracaria.domain.model.Receita;

@Repository
public interface ReceitaRepository extends JpaRepository<Receita, Long>{
	
	@Query("SELECT SUM(valor) FROM Receita")
	public int valorTotal();

}
