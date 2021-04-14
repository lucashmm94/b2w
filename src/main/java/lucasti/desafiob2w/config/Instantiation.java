package lucasti.desafiob2w.config;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import lucasti.desafiob2w.entities.Planeta;
import lucasti.desafiob2w.repositories.PlanetaRepository;

@Configuration
public class Instantiation  implements CommandLineRunner{
	
	@Autowired
	private PlanetaRepository repository;

	@Override
	public void run(String... args) throws Exception {
		repository.deleteAll();

		Planeta terra = new Planeta("Terra", "frio", "firme");
		Planeta marte = new Planeta("Marte", "quente", "lava");
		
		repository.saveAll(Arrays.asList(terra,marte));
		
		
		List<Planeta> lsPlanetas = repository.findAll();
		
		
		for (Planeta p : lsPlanetas) {
			
			System.out.println(p);
			
		}
		
		
	}

}
