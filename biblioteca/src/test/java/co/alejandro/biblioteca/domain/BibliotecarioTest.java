package co.alejandro.biblioteca.domain;

import java.util.Optional;

import org.junit.Test;

import co.alejandro.biblioteca.domain.builder.LibroTestBuilder;
import co.alejandro.biblioteca.domain.builder.LibrosRepositoryTestBuilder;
import co.alejandro.biblioteca.repository.LibrosRepository;
import org.junit.Assert;

public class BibliotecarioTest {
	
	@Test
	public void verLibroYQueExista() {
		// Arrange
		String isbn = "123";
		Libro libro = new LibroTestBuilder().conIsbn(isbn).conNombre("Satanas").build();
		LibrosRepository repository = new LibrosRepositoryTestBuilder().conLibroDisponible(libro).build();
		
		// Act
		Optional<Libro> libroAVer = new Bibliotecario(repository).verLibro(isbn);
		
		// Assert
		Assert.assertTrue(libroAVer.isPresent());
	}
	
	@Test
	public void prestarLibro() {
		// Arrange
		String isbn = "123";
		Libro libro = new LibroTestBuilder().conIsbn(isbn).conNombre("Satanas").build();
		LibrosRepository repository = new LibrosRepositoryTestBuilder().conLibroDisponible(libro).build();
		Bibliotecario bibliotecario = new Bibliotecario(repository);
		
		// Act
		bibliotecario.prestar(isbn);
		
		// Assert
		Assert.assertTrue(bibliotecario.estaPrestado(isbn));
	}
	
	@Test
	public void devolverLibro() {
		// Arrange
		String isbn = "123";
		Libro libro = new LibroTestBuilder().conIsbn(isbn).conNombre("Satanas").build();
		LibrosRepository repository = new LibrosRepositoryTestBuilder().conLibroPrestado(libro).build();
		Bibliotecario bibliotecario = new Bibliotecario(repository);
		
		// Act
		bibliotecario.devolver(libro);
		
		// Assert
		Assert.assertFalse(bibliotecario.estaPrestado(isbn));
		Assert.assertTrue(bibliotecario.verLibro(isbn).isPresent());
	}
}








