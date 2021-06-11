package br.com.starwarsapi.starwars;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import br.com.starwarsapi.starwars.modal.Planeta;


@SpringBootApplication
public class StarWarsApplication {	 
	
	private static final Logger log = LoggerFactory.getLogger(StarWarsApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(StarWarsApplication.class, args);
	}
	
	/*
	 * @Bean public RestTemplate restTemplate(RestTemplateBuilder builder) { return
	 * builder.build(); }
	 * 
	 * @Bean public CommandLineRunner run(RestTemplate restTemplate) throws
	 * Exception { return args -> { Planeta planeta =
	 * restTemplate.getForObject("https://swapi.dev/api", Planeta.class);
	 * log.info(planeta.toString()); }; }
	 */
	
}
