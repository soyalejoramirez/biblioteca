package co.alejandro.biblioteca.domain;

import java.util.Optional;

import co.alejandro.biblioteca.domain.exception.LibroNoExisteException;
import co.alejandro.biblioteca.repository.LibrosRepository;

public class Bibliotecario {
	private static final String LIBRO_NO_DISPONIBLE_O_NO_EXISTENTE = "El libro no existe o no está disponible.";
	private LibrosRepository librosRepository;
	
	public Bibliotecario() {
		librosRepository = new LibrosRepository();
	}
	
	public void adquirirLibro(Libro libro) {
		librosRepository.agregar(libro);
	}
	
	public Optional<Libro> verLibro(String isbn) {
		return librosRepository.getLibroDisponibleByIsbn(isbn);		
	}

	public void prestar(String isbn) {
		Optional<Libro> libroAPrestar = librosRepository.getLibroDisponibleByIsbn(isbn);
		
		if (libroAPrestar.isPresent()) {			
			librosRepository.prestar(libroAPrestar.get());
		} else {
			throw new LibroNoExisteException(LIBRO_NO_DISPONIBLE_O_NO_EXISTENTE);
		}
	}
	
	public boolean estaPrestado(String isbn) {
		return librosRepository.getLibroPrestadoByIsbn(isbn).isPresent();
	}

	public void recibirLibro(Libro libroADevolver) {
		Optional<Libro> libro = librosRepository.getLibroPrestadoByIsbn(libroADevolver.getIsbn());
		
		if (libro.isPresent()) {			
			librosRepository.devolver(libro.get());
		} else {
			throw new LibroNoExisteException(LIBRO_NO_DISPONIBLE_O_NO_EXISTENTE);
		}
	}
}
