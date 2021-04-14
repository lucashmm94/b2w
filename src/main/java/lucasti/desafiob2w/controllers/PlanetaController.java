package lucasti.desafiob2w.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import lucasti.desafiob2w.entities.Planeta;
import lucasti.desafiob2w.services.PlanetaService;


@RestController
@RequestMapping(value="/planetas")
public class PlanetaController {
	
	@Autowired
	PlanetaService service;
	
	@GetMapping
	public ResponseEntity<List<Planeta>> findAll() {
		List<Planeta> lsPlanetas = service.findAll();
		return ResponseEntity.ok().body(lsPlanetas);
	}
	
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Planeta> findById(@PathVariable String id) {
		Planeta planeta = service.findById(id);
		return ResponseEntity.ok().body(planeta);
	}
	
	@GetMapping(value = "/")
	public ResponseEntity<Planeta> findByNome(@RequestParam("nome") String nome) {
		Planeta planeta = service.findByNome(nome);
		return ResponseEntity.ok().body(planeta);
	}


	@PostMapping
	public ResponseEntity<Planeta> save(@RequestBody Planeta planeta) {
		planeta = service.save(planeta);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(planeta.getId())
				.toUri();
		return ResponseEntity.created(uri).body(planeta);
	}
	
	

	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Planeta> deleteById(@PathVariable String id) {
		service.deleteById(id);
		return ResponseEntity.noContent().build();
	}

}
