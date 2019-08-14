package co.alejandro.biblioteca.domain.builder;

import co.alejandro.biblioteca.domain.Autor;
import co.alejandro.biblioteca.domain.Editorial;
import co.alejandro.biblioteca.domain.Genero;
import co.alejandro.biblioteca.domain.Libro;

public class LibroTestBuilder {
	private String isbn;
	private String nombre;
	private Autor autor;
	private Genero genero;
	private Editorial editorial;
	
	public LibroTestBuilder conIsbn(String isbn) {
		this.isbn = isbn;
		return this;
	}
	
	public LibroTestBuilder conNombre(String nombre) {
		this.nombre = nombre;
		return this;
	}
	
	public LibroTestBuilder conAutor(Autor autor) {
		this.autor = autor;
		return this;
	}
	
	public LibroTestBuilder conGenero(Genero genero) {
		this.genero = genero;
		return this;
	}
	
	public LibroTestBuilder conEditorial(Editorial editorial) {
		this.editorial = editorial;
		return this;
	}
	
	public Libro build() {
		return new Libro(isbn, nombre, autor, genero, editorial);
	}
}









