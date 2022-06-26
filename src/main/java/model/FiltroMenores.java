package model;

public class FiltroMenores implements IFiltro {
	
	private static final long serialVersionUID = 1L;
	private String valor;

	public FiltroMenores() {
		this.valor = "FiltroMenores";
	}

	@Override
	public String getValor() {
		return valor;
	}

	@Override
	public String toString() {
		return "FiltroMenores";
	}
}
