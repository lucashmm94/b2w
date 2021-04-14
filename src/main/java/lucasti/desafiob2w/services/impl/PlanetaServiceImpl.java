package lucasti.desafiob2w.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lucasti.desafiob2w.entities.FilmeStarWars;
import lucasti.desafiob2w.entities.Planeta;
import lucasti.desafiob2w.entities.PlanetsResponse;
import lucasti.desafiob2w.exception.ObjectNotFoundException;
import lucasti.desafiob2w.repositories.PlanetaRepository;
import lucasti.desafiob2w.services.FilmeStarWarsService;
import lucasti.desafiob2w.services.PlanetaService;

@Service
public class PlanetaServiceImpl implements PlanetaService {

	@Autowired
	PlanetaRepository repository;

	@Autowired
	FilmeStarWarsService filmeStarWarsService;

	@Override
	public List<Planeta> findAll() {
		return repository.findAll();
	}

	@Override
	public Planeta findById(String id) {
		Planeta planeta = repository.findById(id).get();
		if (planeta == null) {
			throw new ObjectNotFoundException("Objeto não encontrado pelo id!");
		}
		return planeta;
	}

	@Override
	public Planeta save(Planeta planeta) {
		List<FilmeStarWars> listaFilmes = getFilmes();
		int aparicoes = (int) listaFilmes
				.stream()
				.filter(filme -> filme.getName().equalsIgnoreCase(planeta.getNome()))
				.collect(Collectors.toList()).size();
		planeta.setAparicoes(aparicoes);

		return repository.save(planeta);
	}



	@Override
	public void deleteById(String id) {
		Planeta planeta = repository.findById(id).get();
		if (planeta == null) {
			throw new ObjectNotFoundException("Objeto não encontrado pelo id!");
		}
		repository.deleteById(id);

	}

	private List<FilmeStarWars> getFilmes() {
		List<FilmeStarWars> lsFilmesCompleta = new ArrayList<FilmeStarWars>();
		PlanetsResponse lsPlanetasParcial = filmeStarWarsService.getFilmes("1");

		do {

			for (FilmeStarWars filme : lsPlanetasParcial.getResults()) {
				lsFilmesCompleta.add(filme);
			}

			lsPlanetasParcial = filmeStarWarsService.getFilmes(lsPlanetasParcial.getNext().substring(35, 36));
		} while (lsPlanetasParcial.getNext() != null);
		
		
		return lsFilmesCompleta;

	}

	@Override
	public Planeta findByNome(String nome) {
		return repository.findByNome(nome);
	}

}
