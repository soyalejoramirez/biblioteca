package co.alejandro.biblioteca.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Libro {
	private String isbn;
	private String nombre;
	private Autor autor;
	private Genero genero;
	private Editorial editorial;
}
