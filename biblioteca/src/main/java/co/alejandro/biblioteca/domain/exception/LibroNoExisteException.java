package co.alejandro.biblioteca.domain.exception;

public class LibroNoExisteException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public LibroNoExisteException(String message) {
		super(message);
	}

}
