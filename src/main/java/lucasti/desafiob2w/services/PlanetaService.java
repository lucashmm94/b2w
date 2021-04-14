package lucasti.desafiob2w.services;

import java.util.List;

import lucasti.desafiob2w.entities.Planeta;

public interface PlanetaService {
	
	public List<Planeta> findAll();
	
	public Planeta findById(String id);
	
	public Planeta save(Planeta usuario);
	
	public Planeta findByNome(String nome);
	
	public void deleteById(String id);

}
