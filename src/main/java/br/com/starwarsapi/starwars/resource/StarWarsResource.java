package br.com.starwarsapi.starwars.resource;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

	/*
	 * BUSCA POR ID
	 */
	/*
	 * @RequestMapping(value="/buscaPorId/{id}", method = RequestMethod.GET) public
	 * ResponseEntity<Optional<Planeta>> findById(@PathVariable String id) {
	 * 
	 * Optional<Planeta> planeta = planetaRepository.findById(id);
	 * 
	 * if(planeta.isPresent()) { return ResponseEntity.ok().body(planeta); } else {
	 * return ResponseEntity.notFound().build(); } }
	 */

	/*
	 * @RequestMapping(method = RequestMethod.POST) public ResponseEntity<Planeta>
	 * cadastrar(@RequestBody Planeta planeta, UriComponentsBuilder uriBuilder) {
	 * 
	 * planetaRepository.save(planeta);
	 * 
	 * URI uri = uriBuilder.path("/starwars/{id}").build(planeta.getId());
	 * 
	 * return ResponseEntity.created(uri).body(new Planeta(planeta));
	 * 
	 * }
	 * 
	 * 
	 * @RequestMapping(method = RequestMethod.GET) public
	 * ResponseEntity<List<Planeta>> findAll() {
	 * 
	 * List<Planeta> planetas = planetaRepository.findAll();
	 * 
	 * return ResponseEntity.ok().body(planetas); }
	 * 
	 * 
	 * 
	 * BUSCA POR NOME
	 * 
	 * @RequestMapping(value="/buscaPorNome/{nome}", method = RequestMethod.GET)
	 * public ResponseEntity<List<Planeta>> findByNome(@PathVariable String nome) {
	 * 
	 * List<Planeta> planetas = planetaRepository.findByNome(nome);
	 * 
	 * return ResponseEntity.ok().body(planetas); }
	 * 
	 * 
	 * @RequestMapping(value="/{id}", method = RequestMethod.DELETE) public
	 * ResponseEntity<Planeta> remover(@PathVariable String id) {
	 * 
	 * Optional<Planeta> planeta = planetaRepository.findById(id);
	 * 
	 * if(planeta.isPresent()) { planetaRepository.deleteById(id); return
	 * ResponseEntity.ok().build(); } else { return
	 * ResponseEntity.notFound().build(); } }
	 */

}
