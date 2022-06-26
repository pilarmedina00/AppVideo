package model;

public class NoFiltro implements IFiltro {

	private static final long serialVersionUID = 1L;

	private String valor;

	public NoFiltro() {
		this.valor = "NoFiltro";
	}

	@Override
	public String getValor() {
		return valor;
	}

	@Override
	public String toString() {
		return "NoFiltro";
	}
}