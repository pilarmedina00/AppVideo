package model;

public class ExceptionDAO extends Exception {

	private static final long serialVersionUID = 1L;

	public ExceptionDAO(String mensaje) {
        super(mensaje);
    }
}
