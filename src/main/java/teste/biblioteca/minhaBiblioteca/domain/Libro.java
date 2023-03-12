package teste.biblioteca.minhaBiblioteca.domain;

import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Libro {
	
	@Id
	private String id;
	
	private String titulo;
	private String autor;
	private String genero;
	private String editora;
	private boolean alocado;
	
	
	public Libro(String id, String titulo, String autor, String genero, String editora) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.autor = autor;
		this.genero = genero;
		this.editora = editora;
		this.alocado = false;
	}
	
	public Libro(String id, String titulo, String autor, String genero, String editora, boolean alocado) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.autor = autor;
		this.genero = genero;
		this.editora = editora;
		this.alocado = alocado;
	}

	public Libro() {
		
	}

	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public String getAutor() {
		return autor;
	}
	
	public void setAutor(String autor) {
		this.autor = autor;
	}
	
	public String getGenero() {
		return genero;
	}
	
	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	public String getEditora() {
		return editora;
	}
	
	public void setEditora(String editora) {
		this.editora = editora;
	}
	
	public boolean isAlocado() {
		return alocado;
	}
	
	public void setAlocado(boolean alocado) {
		this.alocado = alocado;
	}

	@Override
	public int hashCode() {
		return Objects.hash(titulo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Libro other = (Libro) obj;
		return Objects.equals(titulo, other.titulo);
	}
	
	
	
}
