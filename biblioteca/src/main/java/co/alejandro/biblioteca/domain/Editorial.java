package co.alejandro.biblioteca.domain;

import lombok.Data;

@Data
public class Editorial {
	private String nombre;
	private String ubicacion;
	private Genero especialidad;
}
