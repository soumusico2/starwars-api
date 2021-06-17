package br.com.starwarsapi.starwars.service;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.starwarsapi.starwars.dto.PlanetaDTO;
import br.com.starwarsapi.starwars.dto.PlanetaRespostaApiDTO;
import br.com.starwarsapi.starwars.modal.Planeta;
import br.com.starwarsapi.starwars.repository.PlanetaRepository;

@Service
public class PlanetaService {
	
	
	@Autowired
	private PlanetaRepository planetaRepository;
	
	@Autowired
	public PlanetaService(PlanetaRepository planetaRepository) {
		this.planetaRepository = planetaRepository;
	}
	
	private RestTemplate restTemplate = new RestTemplate();
	
	private final String uri = "https://swapi.dev/api/planets/";
	
	@SuppressWarnings("unlikely-arg-type")
	public ResponseEntity<Planeta> cadastrar(PlanetaDTO planetaForm) throws Exception {
		
		List<PlanetaRespostaApiDTO> planetasRespostaApiList = new ArrayList<PlanetaRespostaApiDTO>();
		Planeta planeta = new Planeta();
		Map<String, Integer> nomePlanetaMap = new HashMap<String, Integer>();
		
		
		planetasRespostaApiList = this.validarPlaneta();
		
		for(int i = 0; i < planetasRespostaApiList.size(); i++) {
			int tamanho = planetasRespostaApiList.get(i).getResults().size();
			for(int y = 0; y < tamanho; y++) {
				nomePlanetaMap.put(planetasRespostaApiList.get(i).getResults().get(y).getName(), planetasRespostaApiList.get(i).getResults().get(y).getFilms().size());
			}
		}
		
		
		if(nomePlanetaMap.containsKey(planetaForm.getNome())) { 
			
			planeta = planetaForm.converterParaPlaneta(planetaForm, nomePlanetaMap.get(planetaForm.getNome()));
			
			Planeta planetaResposta = planetaRepository.findByNome(planeta.getNome());
			
			if(planetaResposta == null) {
				planeta = planetaRepository.save(planeta); 
				return ResponseEntity.ok().body(planeta);
			} else {
				throw new Exception("O Planeta já existe no banco de dados!");
			}
		} else {
			return ResponseEntity.noContent().build();
		}
	}
	
	
	public List<Planeta> listarPlanetas() {
		return planetaRepository.findAll();
	}
	
	public ResponseEntity<Planeta> buscarPorId(String id) {
		
		Optional<Planeta> planeta = planetaRepository.findById(id);

		if (planeta.isPresent()) {
			return ResponseEntity.ok().body(planeta.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	public ResponseEntity<Planeta> buscarPorNome(String nome) {
		Planeta planeta = planetaRepository.findByNome(nome);
		
		if(planeta != null) {
			return ResponseEntity.ok().body(planeta);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	
	public ResponseEntity<Planeta> remover(String id) {
		
		Optional<Planeta> planeta = planetaRepository.findById(id);

		if (planeta.isPresent()) {
			planetaRepository.deleteById(id);
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	public Page<Planeta> listarPorPagina(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		
		return planetaRepository.findAll(pageRequest);
	}
	
	
	private List<PlanetaRespostaApiDTO> validarPlaneta() {

		PlanetaRespostaApiDTO planetaRespostaApi = new PlanetaRespostaApiDTO();
		List<PlanetaRespostaApiDTO> planetaRespostaApiList = new ArrayList<PlanetaRespostaApiDTO>();
		int contador = 1;
		
		do {
			planetaRespostaApi = restTemplate.getForObject(uri.concat("?page=").concat(String.valueOf(contador)), PlanetaRespostaApiDTO.class);
			planetaRespostaApiList.add(planetaRespostaApi);
			contador = contador + 1;
		} while(planetaRespostaApi.getNext() != null);
		
		 
		 return planetaRespostaApiList;

	}
}
