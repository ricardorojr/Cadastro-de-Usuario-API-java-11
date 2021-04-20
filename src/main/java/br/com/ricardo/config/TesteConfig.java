package br.com.ricardo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.ricardo.entities.Endereco;
import br.com.ricardo.entities.Usuario;
import br.com.ricardo.repository.EnderecoRepository;
import br.com.ricardo.repository.UsuarioRepository;

@Configuration
@Profile("test")
public class TesteConfig implements CommandLineRunner{

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Override
	public void run(String... args) throws Exception {
	
	Usuario user1 = new Usuario(null, "Bernardo", "bernardo@gmail.com", "08019054600", "22/04/1987");
	Usuario user2 = new Usuario(null, "Antonio", "antonio@gmail.com", "07597626510", "28/01/1990");
	
	Endereco end1 = new Endereco(null, "Av: Afonso Pena", 155, "casa", "Centro", "Uberlândia", "Minas Gerais", "38400000", user1);
	
	usuarioRepository.saveAll(Arrays.asList(user1, user2));
	enderecoRepository.saveAll(Arrays.asList(end1));
}}
