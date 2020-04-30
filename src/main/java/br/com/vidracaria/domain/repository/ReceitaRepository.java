package br.com.vidracaria.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.vidracaria.domain.model.Receita;

@Repository
public interface ReceitaRepository extends JpaRepository<Receita, Long>{

}
