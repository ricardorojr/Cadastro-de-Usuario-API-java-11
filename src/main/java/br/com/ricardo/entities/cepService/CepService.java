package br.com.ricardo.entities.cepService;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.ricardo.entities.EnderecoCep;

@FeignClient(url= "https://viacep.com.br/ws/" , name = "viacep")
public interface CepService {

    @GetMapping("{cep}/json")
    EnderecoCep buscaEnderecoPorCep(@PathVariable("cep") String cep);
}
