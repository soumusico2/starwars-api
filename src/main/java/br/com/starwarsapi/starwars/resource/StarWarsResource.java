package br.com.starwarsapi.starwars.resource;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import br.com.starwarsapi.starwars.dto.PlanetaDTO;
import br.com.starwarsapi.starwars.modal.Planeta;
import br.com.starwarsapi.starwars.service.PlanetaService;

@RequestMapping("/starwars")
@RestController
public class StarWarsResource {

	@Autowired
	private PlanetaService planetaService;

	final String uri = "https://swapi.dev/api/people/";

	RestTemplate restTemplate = new RestTemplate();

	
	@RequestMapping(value = "/cadastrar" ,method = RequestMethod.POST)
	public ResponseEntity<Planeta> cadastrar(@Valid @RequestBody PlanetaDTO planetaForm) throws Exception {

		return planetaService.cadastrar(planetaForm);
	}

	@RequestMapping(value="/listar", method = RequestMethod.GET)
	public ResponseEntity<List<Planeta>> findAll() {

		List<Planeta> planetas = planetaService.listarPlanetas();
	
		return ResponseEntity.ok().body(planetas);

	}
	 
	@RequestMapping(value="/buscarPorId/{id}", method = RequestMethod.GET) 
	public ResponseEntity<Planeta> buscarPorId(@PathVariable String id) {
	 
	 return planetaService.buscarPorId(id);
	  
	}
	
	@RequestMapping(value="/buscarPorNome/{nome}", method = RequestMethod.GET) 
	public ResponseEntity<Planeta> buscarPorNome(@PathVariable String nome) {
	 
	 return planetaService.buscarPorNome(nome);
	  
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Planeta> remover(@PathVariable String id) {

		return planetaService.remover(id);
		
	}
	
	@RequestMapping(value = "/listarPorPage", method=RequestMethod.GET)
	public ResponseEntity<Page<Planeta>> listarPorPagina(
			@RequestParam(value="page", defaultValue="0") Integer page, 
			@RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage, 
			@RequestParam(value="orderBy", defaultValue="nome") String orderBy, 
			@RequestParam(value="direction", defaultValue="ASC") String direction){
		
		Page<Planeta> cervejas = planetaService.listarPorPagina(page, linesPerPage, orderBy, direction);
		
		return ResponseEntity.ok().body(cervejas);
	}
	
	
}
