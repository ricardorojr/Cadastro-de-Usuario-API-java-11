package br.com.ricardo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ricardo.entities.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long>{

}
