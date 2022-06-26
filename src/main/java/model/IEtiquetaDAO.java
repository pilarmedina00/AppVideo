package model;

import java.util.List;

public interface IEtiquetaDAO {
	
	void crearEtiqueta(Etiqueta etiqueta);

	void borrarEtiqueta(Etiqueta etiqueta);

	void modificarEtiqueta(Etiqueta etiqueta);

	Etiqueta getEtiqueta(int id);

	List<Etiqueta> getEtiquetas();

}
