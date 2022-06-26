package model;

public class FiltroNombresLargos implements IFiltro {

	private static final long serialVersionUID = 1L;

	private String valor;

	public FiltroNombresLargos() {
		this.valor = "FiltroNombresLargos";
	}

	@Override
	public String getValor() {
		return valor;
	}

	@Override
	public String toString() {
		return "FiltroNombresLargos";
	}
}
