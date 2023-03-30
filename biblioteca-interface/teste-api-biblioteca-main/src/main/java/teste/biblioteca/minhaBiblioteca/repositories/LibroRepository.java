package teste.biblioteca.minhaBiblioteca.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import teste.biblioteca.minhaBiblioteca.domain.Libro;

@Repository
public interface LibroRepository extends MongoRepository<Libro, String>{

}
