package co.alejandro.biblioteca.web;

import java.util.Optional;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.alejandro.biblioteca.domain.Autor;
import co.alejandro.biblioteca.domain.Bibliotecario;
import co.alejandro.biblioteca.domain.Editorial;
import co.alejandro.biblioteca.domain.Genero;
import co.alejandro.biblioteca.domain.Libro;

@RestController
@RequestMapping("/api/libros")
@CrossOrigin(origins = "*", maxAge = 3600)
public class LibrosController {
	private Bibliotecario bibliotecario;
	
	public LibrosController() {
		bibliotecario = new Bibliotecario();
		bibliotecario.adquirirLibro(new Libro(	"817", 
												"Días sin ti", 
												new Autor("Elvira", "Sastre", null), 
												new Genero("Novela"),
												new Editorial("Seix Barral", "Barcelona")));
		bibliotecario.adquirirLibro(new Libro(	"316",
												"Hambriento",
												new Autor("Ignacio", "Fornés", "NACH"), 
												new Genero("Poesía"),
												new Editorial("Planeta", "Madrid")));
	}
	
	@GetMapping(value = "/ver/{isbn}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Libro verLibro(@PathVariable("isbn") String isbn) {
		Optional<Libro> libro = bibliotecario.verLibro(isbn);

		if (libro.isPresent()) {
			return libro.get();
		} else {
			return null;
		}
	}
	
	@GetMapping(value = "/estado/{isbn}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public String verEstadoLibro(@PathVariable("isbn") String isbn) {
		return bibliotecario.estaPrestado(isbn) ? "PRESTADO" : "DISPONIBLE";
	}
	
	@GetMapping(value = "/prestar/{isbn}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public void prestar(@PathVariable("isbn") String isbn) {
		bibliotecario.prestar(isbn);
	}
}
