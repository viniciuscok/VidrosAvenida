package br.com.vidracaria.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.vidracaria.domain.model.Cidade;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long>{
	
	List<Cidade> findByEstadoId(Long id);
	
	Cidade findByNomeStartingWithIgnoreCaseAndEstadoSigla(String nomeCidade, String siglaEstado);

	//findByNomeStartingWithIgnoreCaseAndEstadoId
}
