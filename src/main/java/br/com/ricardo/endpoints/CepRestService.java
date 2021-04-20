package br.com.ricardo.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.ricardo.entities.EnderecoCep;
import br.com.ricardo.entities.cepService.CepService;

@RestController
public class CepRestService {

    @Autowired
    private CepService cepService;

    @GetMapping("/{cep}")
    public ResponseEntity<EnderecoCep> getCep(@PathVariable String cep) {

    	EnderecoCep endereco = cepService.buscaEnderecoPorCep(cep);

        return endereco != null ? ResponseEntity.ok().body(endereco) : ResponseEntity.notFound().build(); 
    }

}
