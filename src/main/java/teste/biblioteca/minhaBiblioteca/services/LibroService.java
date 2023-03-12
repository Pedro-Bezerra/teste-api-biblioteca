package teste.biblioteca.minhaBiblioteca.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import teste.biblioteca.minhaBiblioteca.domain.Libro;
import teste.biblioteca.minhaBiblioteca.repositories.LibroRepository;
import teste.biblioteca.minhaBiblioteca.services.exceptions.ObjectNotFoundException;

@Service
public class LibroService {

	@Autowired
	private LibroRepository repo;
	
	public List<Libro> getLibros() {
		return repo.findAll();
	}
	
	public Libro getLibroPeloId(String id) {
		//Optional<Libro> libro = repor.findById(id)
		//											.orElseThrow(e -> new ObjectNotFoundException("Não há um livro com esse ID no acervo.));
		Optional<Libro> libro = repo.findById(id);
		if (!libro.isPresent()) {
			throw new ObjectNotFoundException("Não há um livro com esse id no acervo.");
		} else {
			return libro.get();
		}
	}
	
	public Libro saveLibro(Libro libro) {
		return repo.insert(libro);
	}
	
	public Libro updateLibro(Libro l) {
		Libro newLibro = getLibroPeloId(l.getId());
		newLibro.setTitulo(l.getTitulo());
		newLibro.setAutor(l.getAutor());
		newLibro.setGenero(l.getGenero());
		newLibro.setEditora(l.getEditora());
		return repo.save(newLibro);
	}
	
	public void removeLibro(String id) {
		getLibroPeloId(id);
		repo.deleteById(id);
	}
}
