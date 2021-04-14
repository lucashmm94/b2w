package lucasti.desafiob2w.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import lucasti.desafiob2w.entities.Planeta;

@Repository
public interface PlanetaRepository extends MongoRepository<Planeta, String> {
	
	Planeta findByNome(String nome);

}
