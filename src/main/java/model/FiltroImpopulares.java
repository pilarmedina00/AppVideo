package model;

public class FiltroImpopulares implements IFiltro {
	
	private static final long serialVersionUID = 1L;
	private String valor;

	public FiltroImpopulares() {
		this.valor = "FiltroImpopulares";
	}

	@Override
	public String getValor() {
		return valor;
	}

	@Override
	public String toString() {
		return "FiltroImpopulares";
	}

}
