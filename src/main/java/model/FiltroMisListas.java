package model;

public class FiltroMisListas implements IFiltro {

	private static final long serialVersionUID = 1L;

	private String valor;

	public FiltroMisListas() {
		this.valor = "FiltroMisListas";
	}

	@Override
	public String getValor() {
		return valor;
	}

	@Override
	public String toString() {
		return "FiltroMisListas";
	}
}
