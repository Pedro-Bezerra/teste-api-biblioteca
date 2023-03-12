package teste.biblioteca.minhaBiblioteca.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import teste.biblioteca.minhaBiblioteca.domain.Libro;
import teste.biblioteca.minhaBiblioteca.repositories.LibroRepository;

@Service
public class LibroService {

	@Autowired
	private LibroRepository repo;
	
	public List<Libro> findAll() {
		return repo.findAll();
	}
}
