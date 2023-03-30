package teste.biblioteca.minhaBiblioteca.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import teste.biblioteca.minhaBiblioteca.domain.Libro;
import teste.biblioteca.minhaBiblioteca.services.LibroService;

@RestController
@RequestMapping(value="/libros")
public class LibroResource {
	
	@Autowired
	private LibroService service;

	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Libro>> getLibros() {
		List<Libro> list = service.getLibros();
		return ResponseEntity.ok(list);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Libro> getLibroPeloId(@PathVariable String id) {
		return ResponseEntity.ok().body(service.getLibroPeloId(id));
	}
	
	@PostMapping
	public ResponseEntity<Void> saveLibro(@RequestBody Libro libro) {
		Libro l = service.saveLibro(libro);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(libro.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<Void> saveLibro(@PathVariable String id, @RequestBody Libro libro) {
		Libro newLibro = libro;
		libro.setId(id);
		service.updateLibro(libro);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> removeLibro(@PathVariable String id) {
		service.removeLibro(id);
		return ResponseEntity.noContent().build();
	}
	
	
}
