package br.com.ricardo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ricardo.entities.Usuario;
import br.com.ricardo.repository.UsuarioRepository;
import br.com.ricardo.service.exceptions.ResourceNotFoundException;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	//method para retornar apenas um cliente pelo Id
		public Usuario findById(Long id) {
			Optional<Usuario> obj = usuarioRepository.findById(id);
			return obj.orElseThrow(() -> new ResourceNotFoundException(id));
		}
	

	// method para inserir um usuário
	public Usuario insert(Usuario obj) {
		return usuarioRepository.save(obj);
	}

}
