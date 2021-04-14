package lucasti.desafiob2w.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lucasti.desafiob2w.entities.PlanetsResponse;

@FeignClient(url= "https://swapi.dev/api/" , name = "starwars")
public interface FilmeStarWarsService {

	
	 @GetMapping(value="planets/" ,produces = "application/json;charset=utf-8")
	 PlanetsResponse getFilmes(@RequestParam("page") String page);
	
}
