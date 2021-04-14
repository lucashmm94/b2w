package lucasti.desafiob2w.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FilmeStarWars{
	
	
	private String climate;
	private String name;
	private String population;
	private List<Object> films;
	
	public String getClimate() {
		return climate;
	}
	public void setClimate(String climate) {
		this.climate = climate;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPopulation() {
		return population;
	}
	public void setPopulation(String population) {
		this.population = population;
	}
	public List<Object> getFilms() {
		return films;
	}
	public void setFilms(List<Object> films) {
		this.films = films;
	}
	
	
	@Override
	public String toString() {
		return "FilmeStarWars [climate=" + climate + ", name=" + name + ", population=" + population + "]";
	}
	

}
