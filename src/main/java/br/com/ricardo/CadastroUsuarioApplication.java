package br.com.ricardo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CadastroUsuarioApplication {

	public static void main(String[] args) {
		SpringApplication.run(CadastroUsuarioApplication.class, args);
	}

}
