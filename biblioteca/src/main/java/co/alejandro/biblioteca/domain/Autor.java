package co.alejandro.biblioteca.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Autor {
	private String nombre;
	private String apellido;
	private String seudonimo;
}
