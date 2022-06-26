package model;

import java.util.*;

public class CatalogoEtiquetas {

	private Map<String, Etiqueta> tags;
	private Map<Integer, Etiqueta> idTags;
	private static CatalogoEtiquetas unicaInstancia;

	private AbsFactoriaDAO absFactoriaDAO;
	
	public static CatalogoEtiquetas getUnicaInstancia() {
		if (unicaInstancia == null) {
			unicaInstancia = new CatalogoEtiquetas();
		}
		return unicaInstancia;
	}

	private CatalogoEtiquetas() {
		tags = new HashMap<>();
		idTags = new HashMap<>();

		try {
			absFactoriaDAO = AbsFactoriaDAO.getInstancia();
		} catch (ExceptionDAO e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		List<Etiqueta> etiquetas = (List<Etiqueta>) absFactoriaDAO.getEtiquetaDAO().getEtiquetas();
		for (Etiqueta tag : etiquetas) {
			this.tags.put(tag.getNombre(), tag);
			this.idTags.put(tag.getId(), tag);
		}
	}

	public Etiqueta getEtiqueta(String texto) {
		return this.tags.get(texto);
	}

	public boolean existeEtiqueta(String texto) {
		return this.tags.containsKey(texto);
	}

	public void crearEtiqueta(Etiqueta etiqueta) {
		System.out.println("Tag added: " + etiqueta.toString());
		this.tags.put(etiqueta.getNombre(), etiqueta);
		this.idTags.put(etiqueta.getId(), etiqueta);
	}

	public void borraEtiqueta(Etiqueta etiqueta) {
		this.tags.remove(etiqueta.getNombre());
		this.idTags.remove(etiqueta.getId());
	}

}
