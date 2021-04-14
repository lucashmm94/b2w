package lucasti.desafiob2w.services.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import lucasti.desafiob2w.entities.Planeta;
import lucasti.desafiob2w.repositories.PlanetaRepository;
import lucasti.desafiob2w.services.PlanetaService;

@RunWith(SpringRunner.class)
@WebAppConfiguration
@SpringBootTest
class PlanetaServiceImplTest {
	
	@Autowired
	PlanetaService service;
	@Autowired
	PlanetaRepository repository;
	

	@Test
	void testFindAll() {	
	repository.deleteAll();
	
	Planeta terra = new Planeta("Terra","Variavel","Plano");
	Planeta marte = new Planeta("Terra","Quente","Irregular");
	
	repository.save(terra);
	repository.save(marte);
	
	assertTrue(service.findAll().size() == 2);
	
	}

	@Test
	void testFindById() {
		
		Planeta terra = new Planeta("Terra","Variavel","Plano");

		repository.save(terra);

		assertTrue(repository.existsById(terra.getId()));
	}

	@Test
	void testSave() {
		Planeta terra = new Planeta("Terra","Variavel","Plano");
		
		repository.save(terra);
		
		assertThat(terra.getId()).isNotNull();
		assertThat(terra.getNome()).isEqualTo("Terra");
		assertThat(terra.getClima()).isEqualTo("Variavel");
		assertThat(terra.getTerreno()).isEqualTo("Plano");
		
	}

	

	@Test
	void testDeleteById() {
		Planeta planeta = new Planeta("Terra","Variavel","Plano");
		
		repository.save(planeta);

		service.deleteById(planeta.getId());

		assertThat(repository.existsById(planeta.getId())).isFalse();
	}

}
