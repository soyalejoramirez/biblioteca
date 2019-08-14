package co.alejandro.biblioteca.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import co.alejandro.biblioteca.domain.Libro;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class LibrosRepository {
	private List<Libro> disponibles;
	private List<Libro> prestados;
	
	public LibrosRepository() {
		disponibles = new ArrayList<>();
		prestados = new ArrayList<>();
	}
	
	public void agregar(Libro libro) {
		disponibles.add(libro);
	}
	
//	public Libro getLibroDisponibleByIsbn(String isbn) {
//		for (Libro libro : disponibles) {
//			if (isbn.equals(libro.getIsbn())) {
//				return libro;
//			}
//		}
//		
//		return null;
//	}
	
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
		prestados.remove(libro);
		disponibles.add(libro);
	}
}
