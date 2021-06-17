package br.com.starwarsapi.starwars;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.verify;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import br.com.starwarsapi.starwars.modal.Planeta;
import br.com.starwarsapi.starwars.repository.PlanetaRepository;
import br.com.starwarsapi.starwars.service.PlanetaService;

public class PlanetaServiceTest {
	
	@InjectMocks
	PlanetaService planetaService;
	
	@Mock
	private PlanetaRepository planetaRepository;
	
	Planeta planeta = new Planeta("Teste", "Teste", "Teste", 5);
	
	List<Planeta> planetas = new ArrayList<>();
	
	@SuppressWarnings("deprecation")
	@BeforeEach
	public void beforeEach() {
		MockitoAnnotations.initMocks(this);
		this.planetaService = new PlanetaService(planetaRepository);
	
	}

	@Test
	void cadastrar() throws Exception {
		Mockito.when(planetaRepository.save(planeta)).thenReturn(planeta);
	}
	
	
	@Test
	void deletar() throws Exception {

		Mockito.when(planetaRepository.findById(planeta.getId())).thenReturn(Optional.of(planeta));
		planetaService.remover(planeta.getId());
		
		
		verify(planetaRepository).deleteById(planeta.getId());

	}
	
	 
	@Test
	void buscar() throws Exception {
		Mockito.when(planetaRepository.findById(planeta.getId())).thenReturn(Optional.of(planeta));
	}
	
	@Test
	void listar() throws Exception {
		Mockito.when(planetaRepository.findAll()).thenReturn(planetas);
	}
}
