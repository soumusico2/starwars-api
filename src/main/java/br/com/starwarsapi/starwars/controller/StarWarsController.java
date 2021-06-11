package br.com.starwarsapi.starwars.controller;

import java.net.URI;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.starwarsapi.starwars.modal.People;
import br.com.starwarsapi.starwars.modal.Planeta;
import br.com.starwarsapi.starwars.repository.PlanetaRepository;

@RequestMapping("/starwars")
@RestController
public class StarWarsController {
	
	@Autowired
	private PlanetaRepository planetaRepository;
	
	final String uri = "https://swapi.dev/api/people/";
	
	RestTemplate restTemplate = new RestTemplate();
	
	
	
	/*
	 * BUSCA POR ID
	 */
	@RequestMapping(value="/people/{id}", method = RequestMethod.GET)
	public ResponseEntity<People> peopleFindById(@PathVariable Long id) {
		
		
		// headers = new HttpHeaders();
	   // headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	   // headers.set("X-COM-PERSIST", "NO");
	    //headers.set("X-COM-LOCATION", "BR");
	 
	   // HttpEntity<String> entity = new HttpEntity<String>(headers);
		
	    //ResponseEntity<String> response = restTemplate.exchange(uri.concat(id.toString()).concat("/"), HttpMethod.GET, entity, String.class);
		
		People people = restTemplate.getForObject(uri.concat(id.toString()).concat("/"), People.class);

		System.out.println(people.toString());
		
		return ResponseEntity.ok().body(people);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	 * BUSCA POR ID
	 */
	@RequestMapping(value="/buscaPorId/{id}", method = RequestMethod.GET)
	public ResponseEntity<Optional<Planeta>> findById(@PathVariable String id) {
		
		Optional<Planeta> planeta = planetaRepository.findById(id);
		
		if(planeta.isPresent()) {
			return ResponseEntity.ok().body(planeta);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Planeta> cadastrar(@RequestBody Planeta planeta, UriComponentsBuilder uriBuilder) {
		
		planetaRepository.save(planeta);
		
		URI uri = uriBuilder.path("/starwars/{id}").build(planeta.getId());
		
		return ResponseEntity.created(uri).body(new Planeta(planeta));
		
	}
	
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Planeta>> findAll() {
			
		List<Planeta> planetas = planetaRepository.findAll();
		
		return ResponseEntity.ok().body(planetas);
	}
	
	
	/*
	 * BUSCA POR NOME
	 */
	@RequestMapping(value="/buscaPorNome/{nome}", method = RequestMethod.GET)
	public ResponseEntity<List<Planeta>> findByNome(@PathVariable String nome) {
		
		List<Planeta> planetas = planetaRepository.findByNome(nome);
		
		return ResponseEntity.ok().body(planetas);
	}
	
	
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Planeta> remover(@PathVariable String id) {
		
		Optional<Planeta> planeta = planetaRepository.findById(id);
		
		if(planeta.isPresent()) {
			planetaRepository.deleteById(id);
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
}
