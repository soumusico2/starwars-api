package br.com.starwarsapi.starwars.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.starwarsapi.starwars.modal.People;


public interface PeopleRepository extends MongoRepository<People, Long> {

}
