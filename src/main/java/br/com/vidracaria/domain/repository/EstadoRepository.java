package br.com.vidracaria.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.vidracaria.domain.model.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long> {

	//@Query(value = "from Estado where silga=sigla")
	public Estado findBySigla(String sigla);
}
