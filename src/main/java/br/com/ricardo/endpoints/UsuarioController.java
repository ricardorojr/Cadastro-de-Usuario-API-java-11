package br.com.ricardo.endpoints;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.ricardo.entities.Usuario;
import br.com.ricardo.service.UsuarioService;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	//insere um usuário
	@PostMapping(produces = {MimeTypeUtils.APPLICATION_JSON_VALUE},
			consumes = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<Usuario> insert(@RequestBody @Valid Usuario obj) {	
		obj = usuarioService.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
		
	//retornar apenas um usuario pelo Id
		@GetMapping(value = "/{id}")
		public ResponseEntity<Usuario> findById(@PathVariable Long id) {
			Usuario obj = usuarioService.findById(id);
			return ResponseEntity.ok().body(obj);
		}
	
}
