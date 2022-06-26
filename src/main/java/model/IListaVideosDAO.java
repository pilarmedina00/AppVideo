package model;

import java.util.List;

public interface IListaVideosDAO {
	
	void crearListaVideos(ListaVideos listaVideos);

	void borrarListaVideos(ListaVideos listaVideos);

	void modificarListaVideos(ListaVideos listaVideos);

	ListaVideos getListaVideos(int id);

	List<ListaVideos> getListasVideos();

}
