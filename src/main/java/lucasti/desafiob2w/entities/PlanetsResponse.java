package lucasti.desafiob2w.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PlanetsResponse {
	private Integer count;
	private String next ;
	private String previous;
	private List<FilmeStarWars> results;
	
	
	

	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public String getNext() {
		return next;
	}
	public void setNext(String next) {
		this.next = next;
	}
	public String getPrevious() {
		return previous;
	}
	public void setPrevious(String previous) {
		this.previous = previous;
	}
	public List<FilmeStarWars> getResults() {
		return results;
	}
	public void setResults(List<FilmeStarWars> results) {
		this.results = results;
	}
	

}
