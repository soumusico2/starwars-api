package br.com.starwarsapi.starwars.dto;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import br.com.starwarsapi.starwars.modal.Planeta;

public class PlanetaDTO {
	
	@Length(min=3, max=15, message="O tamanho deve ser entre 5 a 15 caracteres")
	@NotEmpty(message="Preenchimento obrigatório")
	private String nome;
	
	@Length(min=3, max=15, message="O tamanho deve ser entre 5 a 15 caracteres")
	@NotEmpty(message="Preenchimento obrigatório")
	private String clima;
	
	@Length(min=3, max=15, message="O tamanho deve ser entre 5 a 15 caracteres")
	@NotEmpty(message="Preenchimento obrigatório")
	private String terreno;
	
	public PlanetaDTO() {}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getClima() {
		return clima;
	}

	public void setClima(String clima) {
		this.clima = clima;
	}

	public String getTerreno() {
		return terreno;
	}

	public void setTerreno(String terreno) {
		this.terreno = terreno;
	}

	public Planeta converterParaPlaneta(PlanetaDTO planetaForm, Integer qantFilmes) {
		
		return new Planeta(planetaForm.getNome(), planetaForm.getClima(), planetaForm.getTerreno(), qantFilmes);
	}
	
	
	
}
