package br.com.ricardo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ricardo.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{


}
