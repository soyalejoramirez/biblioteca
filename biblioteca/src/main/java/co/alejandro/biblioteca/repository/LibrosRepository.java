package co.alejandro.biblioteca.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import co.alejandro.biblioteca.domain.Libro;

public class LibrosRepository {
	private List<Libro> disponibles;
	private List<Libro> prestados;
	
	public LibrosRepository() {
		disponibles = new ArrayList<>();
		prestados = new ArrayList<>();
	}
	
	public Optional<Libro> getLibroDisponibleByIsbn(String isbn) {
		return disponibles.stream().filter(libro -> libro.getIsbn().equals(isbn)).findFirst();
	}

	public Optional<Libro> getLibroPrestadoByIsbn(String isbn) {
		return prestados.stream().filter(libro -> libro.getIsbn().equals(isbn)).findFirst();
	}

	public void prestar(Libro libro) {
		prestados.add(libro);
		disponibles.remove(libro);
	}
	
	public void devolver(Libro libro) {
		disponibles.add(libro);
		prestados.add(libro);
	}
}
