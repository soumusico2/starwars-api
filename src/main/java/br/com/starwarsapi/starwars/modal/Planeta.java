package br.com.starwarsapi.starwars.modal;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "planeta")
public class Planeta {
	
	@Id
	private String id;
	
	private String nome;
	private String clima;
	private String terreno;
	
	
	private String people;
	private String planets;
	private String films;
	private String species;
	private String vehicles;
	private String starships;
	
	public Planeta() {}
	
	public Planeta(String nome, String clima, String terreno) {
		super();
		this.nome = nome;
		this.clima = clima;
		this.terreno = terreno;
	}
	
	public Planeta(Planeta planeta) {
		super();
		this.nome = planeta.getNome();
		this.clima = planeta.getClima();
		this.terreno = planeta.getTerreno();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Planeta other = (Planeta) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public String getPeople() {
		return people;
	}

	public void setPeople(String people) {
		this.people = people;
	}

	public String getPlanets() {
		return planets;
	}

	public void setPlanets(String planets) {
		this.planets = planets;
	}

	public String getFilms() {
		return films;
	}

	public void setFilms(String films) {
		this.films = films;
	}

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	public String getVehicles() {
		return vehicles;
	}

	public void setVehicles(String vehicles) {
		this.vehicles = vehicles;
	}

	public String getStarships() {
		return starships;
	}

	public void setStarships(String starships) {
		this.starships = starships;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Planeta [id=");
		builder.append(id);
		builder.append(", nome=");
		builder.append(nome);
		builder.append(", clima=");
		builder.append(clima);
		builder.append(", terreno=");
		builder.append(terreno);
		builder.append(", people=");
		builder.append(people);
		builder.append(", planets=");
		builder.append(planets);
		builder.append(", films=");
		builder.append(films);
		builder.append(", species=");
		builder.append(species);
		builder.append(", vehicles=");
		builder.append(vehicles);
		builder.append(", starships=");
		builder.append(starships);
		builder.append("]");
		return builder.toString();
	}
	
}
