package br.com.ricardo.endpoints;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.ricardo.entities.Endereco;
import br.com.ricardo.service.EnderecoService;

@RestController
@RequestMapping(value = "/endereco")
public class EnderecoController {

	@Autowired
	private EnderecoService enderecoService;

	// insere um endereço
	@PostMapping(produces = { MimeTypeUtils.APPLICATION_JSON_VALUE }, consumes = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<Endereco> insert(@RequestBody @Valid Endereco obj) {
		obj = enderecoService.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId_endereco())
				.toUri();
		return ResponseEntity.created(uri).body(obj);
	}

}
