package br.com.starwarsapi.starwars.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.starwarsapi.starwars.modal.Planeta;
import br.com.starwarsapi.starwars.repository.PlanetaRepository;

@Service
public class PlanetaService {

	@Autowired
	private PlanetaRepository planetaRepository;
	
	private RestTemplate restTemplate = new RestTemplate();
	
	private final String uri = "https://swapi.dev/api/planets/";
	
	public Planeta cadastrar(Planeta planetaForm) {
		
		this.validarPlaneta();
		
		Planeta planeta = planetaRepository.save(planetaForm);
		
		return planeta;
	}
	
	public Planeta validarPlaneta() {

		
		
		 Planeta planeta = restTemplate.getForObject(uri, Planeta.class);
		 
		 System.out.println(planeta.toString());
		 
		 return planeta;
		 
		 
	}
}
