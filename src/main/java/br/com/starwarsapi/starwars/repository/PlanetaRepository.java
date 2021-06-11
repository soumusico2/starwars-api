package br.com.starwarsapi.starwars.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.starwarsapi.starwars.modal.Planeta;

public interface PlanetaRepository extends MongoRepository<Planeta, String> {
	
	List<Planeta> findByNome(String nome);
}
