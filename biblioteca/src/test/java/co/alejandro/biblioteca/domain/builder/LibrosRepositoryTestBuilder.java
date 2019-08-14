package co.alejandro.biblioteca.domain.builder;

import java.util.ArrayList;
import java.util.List;

import co.alejandro.biblioteca.domain.Libro;
import co.alejandro.biblioteca.repository.LibrosRepository;

public class LibrosRepositoryTestBuilder {
	private List<Libro> disponibles;
	private List<Libro> prestados;
	
	public LibrosRepositoryTestBuilder() {
		this.disponibles = new ArrayList<Libro>();
		this.prestados = new ArrayList<Libro>();
	}
	
	public LibrosRepositoryTestBuilder conLibroDisponible(Libro libro) {
		this.disponibles.add(libro);
		return this;
	}
	
	public LibrosRepositoryTestBuilder conLibroPrestado(Libro libro) {
		this.prestados.add(libro);
		return this;
	}
	
	public LibrosRepository build() {
		return new LibrosRepository(disponibles, prestados);
	}
}
