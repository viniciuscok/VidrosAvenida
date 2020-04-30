package br.com.vidracaria.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.vidracaria.domain.model.Cartao;

@Repository
public interface CartaoRepository extends JpaRepository<Cartao, Long>{

}
