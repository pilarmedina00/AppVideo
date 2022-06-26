package controlador;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import model.*;
import umu.tds.videos.BuscadorVideos;
import umu.tds.videos.VideosEvent;
import umu.tds.videos.VideosListener;

public class AppVideo {
	private static AppVideo unicaInstancia;

	private AbsFactoriaDAO factoriaDAO;
	private IUsuarioDAO usuarioDAO;
	private IListaVideosDAO listaVideosDAO;
	private IVideoDAO videoDAO;
	private IEtiquetaDAO etiquetaDAO;
	private int numVideos;
	private BuscadorVideos buscadorVideos;

	Usuario usuarioActual;
	private Video videoSeleccionado;

	private AppVideo() {

		setNumVideos(0);
		usuarioActual = null;
		try {
			factoriaDAO = AbsFactoriaDAO.getInstancia();
		} catch (ExceptionDAO e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		listaVideosDAO = factoriaDAO.getListaVideosDAO();
		usuarioDAO = factoriaDAO.getUsuarioDAO();
		videoDAO = factoriaDAO.getVideoDAO();
		etiquetaDAO = factoriaDAO.getEtiquetaDAO();
		buscadorVideos = new BuscadorVideos();

		CatalogoVideos.getUnicaInstancia();
		CatalogoUsuarios.getUnicaInstancia();
		CatalogoEtiquetas.getUnicaInstancia();

		buscadorVideos.addVideosListener(new VideosListener() {
			@Override
			public void nuevosVideos(VideosEvent evento) {
				setNumVideos(0);
				for (umu.tds.videos.Video video : evento.getVideos().getVideo()) {
					Video v = new Video(video.getTitulo(), video.getUrl());
					List<Etiqueta> etiquetas = new LinkedList<>();

					for (umu.tds.videos.Etiqueta e : video.getEtiqueta()) {
						if (!CatalogoEtiquetas.getUnicaInstancia().existeEtiqueta(e.getNombre())) {
							Etiqueta etiqueta = new Etiqueta(e.getNombre());
							etiquetas.add(etiqueta);
							etiquetaDAO.crearEtiqueta(etiqueta);
							CatalogoEtiquetas.getUnicaInstancia().crearEtiqueta(etiqueta);
						} else {
							etiquetas.add(CatalogoEtiquetas.getUnicaInstancia().getEtiqueta(e.getNombre()));
						}
					}
					v.setEtiquetas(etiquetas);

					if (!CatalogoVideos.getUnicaInstancia().existeVideo(v)) {
						videoDAO.crearVideo(v);
						CatalogoVideos.getUnicaInstancia().addVideo(v);
						setNumVideos(getNumVideos() + 1);
					}
				}
			}
		});
	}

	public static AppVideo getUnicaInstancia() {
		if (unicaInstancia == null) {
			unicaInstancia = new AppVideo();
		}
		return unicaInstancia;
	}

	public boolean existeUsuario(String username) {
		return CatalogoUsuarios.getUnicaInstancia().getUsuario(username) != null;
	}

	public boolean login(String username, String password) {
		Usuario user = CatalogoUsuarios.getUnicaInstancia().getUsuario(username);
		if (user != null && user.getPassword().equals(password)) {
			usuarioActual = user;
			return true;
		}
		return false;
	}

	public void logout() {
		this.usuarioActual = null;
	}

	public void generarPDF(Usuario usuario, String ruta) {
		Document pdf = new Document(PageSize.A4, 30, 30, 30, 30);
		FileOutputStream output;
		Font titulo = FontFactory.getFont(FontFactory.COURIER, 16);
		titulo.setColor(BaseColor.BLACK);
		Font info = FontFactory.getFont(FontFactory.COURIER, 14);
		info.setColor(BaseColor.DARK_GRAY);
		Font lista = FontFactory.getFont(FontFactory.COURIER, 12);
		lista.setColor(BaseColor.BLUE);
		try {
			output = new FileOutputStream(ruta + "/playlists-" + usuario.getUsername() + ".pdf");
			PdfWriter.getInstance(pdf, output);
			pdf.open();

			Paragraph parrafo = new Paragraph();
			parrafo.add(new Phrase("AppVideo playlist from user " + usuario.getNombre() + " " + usuario.getApellidos(),
					titulo));
			parrafo.add(new Phrase(Chunk.NEWLINE));
			parrafo.add(new Phrase("Username : " + usuario.getUsername(), titulo));
			parrafo.add(new Phrase(Chunk.NEWLINE));

			pdf.add(parrafo);

			for (ListaVideos playlist : usuario.getListasReproduccion()) {
				PdfPTable tabla = new PdfPTable(2);
				Paragraph parrafoLista = new Paragraph();
				parrafoLista.add(new Phrase("Playlist: " + playlist.getNombreLista(), lista));
				parrafoLista.add(new Phrase(Chunk.NEWLINE));

				pdf.add(parrafoLista);

				if (!playlist.getVideos().isEmpty()) {
					tabla.addCell("Title");
					tabla.addCell("Visualizations");

					for (Video video : playlist.getVideos()) {
						tabla.addCell(video.getTitulo());
						tabla.addCell(Integer.toString(video.getNumReproducciones()));
					}
				}
				pdf.add(tabla);

				Paragraph parrafoFinal = new Paragraph();
				parrafoFinal.add(new Phrase(Chunk.NEWLINE));
				pdf.add(parrafoFinal);
			}

			pdf.close();
			output.close();
		} catch (IOException | DocumentException e) {
		}
	}

	public boolean registrarUsuario(String nombre, String apellidos, String email, String username, String password,
			String repPassword, LocalDate fechaNacimiento) {
		if (existeUsuario(username)) {
			return false;
		}
		if (password.equals(repPassword)) {
			return false;
		}
		Usuario usuario = new Usuario(nombre, apellidos, email, username, password, fechaNacimiento);
		usuario.setFechaRegistro(LocalDate.now());
		usuarioDAO.crearUsuario(usuario);
		CatalogoUsuarios.getUnicaInstancia().crearUsuario(usuario);
		return true;
	}

	public Usuario getUsuarioActual() {
		return this.usuarioActual;
	}

	public void actualizarUsuario(String nombre, String apellidos, String email, LocalDate fechaNacimiento) {
		usuarioActual.setNombre(nombre);
		usuarioActual.setApellidos(apellidos);
		usuarioActual.setEmail(email);
		usuarioActual.setFechaNacimiento(fechaNacimiento);
		usuarioDAO.modificarUsuario(usuarioActual);
	}

	public void cambiarArchivoComponente(String rutaXML) {
		buscadorVideos.setArchivoVideos(rutaXML);
	}

	public void mejorarCuenta(Usuario usuario) {
		usuario.setPremium(true);
		usuarioDAO.modificarUsuario(usuario);
	}

	public void cancelarSuscripcion(Usuario usuario) {
		usuario.setPremium(false);
		usuarioDAO.modificarUsuario(usuario);
	}

	public void setTipoFiltro(Usuario usuario, String filtro) {
		usuarioActual.setTipoFiltro(filtro);
		usuarioDAO.modificarUsuario(usuario);
	}

	public List<ListaVideos> recuperarListasUsuario(Usuario usuario) {
		return usuario.getListasReproduccion();
	}

	public void addVideoRecientes(Usuario usuario, Video video) {
		usuario.addRecientes(video);
		usuarioDAO.modificarUsuario(usuario);
	}

	public void addReproduccion(Video video) {
		video.addReproduccion();
		videoDAO.modificarVideo(video);
	}

	public void addVideoVistoUsuario() {
		this.usuarioActual.addVideoVisto();
	}

	public void addEtiquetaVideo(Etiqueta etiqueta, Video video) {
		if (video.addEtiqueta(etiqueta)) {
			if (!CatalogoEtiquetas.getUnicaInstancia().existeEtiqueta(etiqueta.getNombre())) {
				etiquetaDAO.crearEtiqueta(etiqueta);
				CatalogoEtiquetas.getUnicaInstancia().crearEtiqueta(etiqueta);
			}
			videoDAO.modificarVideo(video);
		}
	}

	public void removeEtiquetaVideo(Etiqueta etiqueta, Video video) {
		int x = 0;
		if (video.removeEtiqueta(etiqueta)) {
			for (Video v : CatalogoVideos.getUnicaInstancia().getVideos()) {
				if (v.getEtiquetas().contains(etiqueta)) {
					x = 1;
				}
			}
		}
		videoDAO.modificarVideo(video);

		if (x == 0) {
			CatalogoEtiquetas.getUnicaInstancia().borraEtiqueta(etiqueta);
			etiquetaDAO.borrarEtiqueta(etiqueta);
		}
	}

	public void addVideoMasVistos(Usuario usuario, Video video) {
		usuario.addVideoMasVistos(video);
		usuarioDAO.modificarUsuario(usuario);
	}

	public List<Video> getMasReproducidosAplicacion() {
		return CatalogoVideos.getUnicaInstancia().getTrendingVideos();
	}

	public List<Video> getVideosRecientes(Usuario usuario) {
		return usuario.getListaRecientes();
	}

	public void actualizarLista(Usuario usuario, String nombreLista, List<Video> videos) {
		ListaVideos lista = usuario.getListaVideos(nombreLista);
		lista.setVideos(videos);
		listaVideosDAO.modificarListaVideos(lista);
	}
	
	public void addVideoLista(Usuario usuario, String nombreLista, Video video) {
		ListaVideos lista = usuario.getListaVideos(nombreLista);
		lista.addVideo(video);
		listaVideosDAO.modificarListaVideos(lista);
	}

	public void crearLista(Usuario usuario, String nombreLista, List<Video> videos) {
		ListaVideos lista = usuario.createListaVideos(nombreLista, videos);
		listaVideosDAO.crearListaVideos(lista);
		usuario.addListaVideos(lista);
		usuarioDAO.modificarUsuario(usuario);
	}

	public void borrarListaVideos(Usuario usuario, ListaVideos lista) {
		usuario.removeListaVideos(lista);
		usuarioDAO.modificarUsuario(usuario);
		listaVideosDAO.borrarListaVideos(lista);
	}

	public List<Video> getVideosCatalogo() {
		return CatalogoVideos.getUnicaInstancia().getVideos();
	}

	public Video getVideoSeleccionado() {
		return this.videoSeleccionado;
	}

	public void setVideoSeleccionado(Video video) {
		this.videoSeleccionado = video;
	}

	public List<Video> getMasReproducidosUsuario(Usuario usuarioActual) {

		HashMap<Video, Integer> masVistos = new HashMap<>(usuarioActual.getMasVistos());

		List<Map.Entry<Video, Integer>> list = new LinkedList<Map.Entry<Video, Integer>>(masVistos.entrySet());

		Collections.sort(list, new Comparator<Map.Entry<Video, Integer>>() {
			@Override
			public int compare(Entry<Video, Integer> o1, Entry<Video, Integer> o2) {
				return (o1.getValue()).compareTo(o2.getValue());
			}
		});
		List<Video> listaOrdenada = new LinkedList<Video>();
		for (Map.Entry<Video, Integer> entrada : list) {
			if (listaOrdenada.size() < 10) {
				listaOrdenada.add(entrada.getKey());
			}
		}
		return listaOrdenada;
	}

	public int getNumVideos() {
		return numVideos;
	}

	public void setNumVideos(int numVideos) {
		this.numVideos = numVideos;
	}
}
