package co.alejandro.biblioteca.domain;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import co.alejandro.biblioteca.domain.builder.LibroTestBuilder;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LibroTest {

	@Test
	public void crearLibroTest() {
		// Arrange
		String isbn = "987";
		String nombre = "Cien años de soledad";
		Autor autor = new Autor("Gabriel", "Garcia", "Gabo");
		Editorial editorial = new Editorial("Planeta", "Bogotá");
		Genero genero = new Genero("Novela");
		
		// Act
		Libro libro = new LibroTestBuilder().conIsbn(isbn).conNombre(nombre)
						.conAutor(autor).conEditorial(editorial).conGenero(genero).build();
		
		// Assert
		Assert.assertEquals(nombre, libro.getNombre());
		Assert.assertEquals(isbn, libro.getIsbn());
	}

}






