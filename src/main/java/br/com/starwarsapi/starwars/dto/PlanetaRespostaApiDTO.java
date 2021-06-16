package br.com.starwarsapi.starwars.dto;

import java.util.ArrayList;
import java.util.List;

import br.com.starwarsapi.starwars.modal.Resultado;

public class PlanetaRespostaApiDTO {
	
	List<Resultado> results = new ArrayList<Resultado>();
	private String next;
	
	
	public List<Resultado> getResults() {
		return results;
	}

	public void setResults(List<Resultado> results) {
		this.results = results;
	}
	
	public String getNext() {
		return next;
	}

	public void setNext(String next) {
		this.next = next;
	}
}
