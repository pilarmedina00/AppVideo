package model;

import java.util.*;

public class CatalogoVideos {
	private Map<String, Video> videos;

	private static CatalogoVideos unicaInstancia;
	private AbsFactoriaDAO factoriaDAO;

	public static CatalogoVideos getUnicaInstancia() {
		if (unicaInstancia == null) {
			unicaInstancia = new CatalogoVideos();
		}
		return unicaInstancia;
	}

	private CatalogoVideos() {
		videos = new HashMap<>();

		try {
			factoriaDAO = FactoriaDAO.getInstancia(FactoriaDAO.FACTORIA_DAO);
			List<Video> videos = factoriaDAO.getVideoDAO().getVideos();
			for (Video v : videos) {
				this.videos.put(v.getTitulo(), v);
			}
		} catch (ExceptionDAO e) {
			e.printStackTrace();
		}
	}

	public void addVideo(Video video) {
		videos.put(video.getTitulo(), video);
	}

	public boolean existeVideo(Video video) {
		return this.videos.containsValue(video);
	}

	public List<Video> getVideos() {
		return new ArrayList<>(this.videos.values());
	}

	// Conseguir la lista de los 10 videos mas reproducidos
	public List<Video> getTrendingVideos() {
		List<Video> masReproducidos = new LinkedList<>(getVideos());
		Collections.sort(masReproducidos, new Comparator<Video>() {
			@Override
			public int compare(Video o1, Video o2) {
				Integer objeto1 = o1.getNumReproducciones();
				Integer objeto2 = o1.getNumReproducciones();
				return objeto1.compareTo(objeto2);
			}
		});
		
		List<Video> listaOrdenada = new LinkedList<Video>();
		for (Video video : masReproducidos) {
			if (listaOrdenada.size() < 10) {
				listaOrdenada.add(video);
			}
		}
		return listaOrdenada;
	}

}
