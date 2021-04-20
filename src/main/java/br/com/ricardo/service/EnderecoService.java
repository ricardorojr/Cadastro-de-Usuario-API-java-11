package br.com.ricardo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ricardo.entities.Endereco;
import br.com.ricardo.repository.EnderecoRepository;

@Service
public class EnderecoService {
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	//method para inserir um endereço
		public Endereco insert(Endereco obj) {
				return enderecoRepository.save(obj);
		}
}
