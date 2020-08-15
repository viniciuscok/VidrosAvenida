package br.com.vidracaria.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.vidracaria.domain.model.SubCategoria;

@Repository
public interface SubCategoriaRepository extends JpaRepository<SubCategoria, Long>{
	

}
