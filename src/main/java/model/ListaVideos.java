package model;

import javax.persistence.*;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "ListaVideos")
public class ListaVideos implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "idList")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "nombre")
	private String nombreLista;

	@Column(name = "fechaCreacion")
	private LocalDate fechaCreacion;

	@Fetch(FetchMode.SELECT)
	@ManyToMany(fetch = FetchType.EAGER)
	private List<Video> videos;

	public ListaVideos(String nombreLista, List<Video> videos) {
		this.nombreLista = nombreLista;
		this.videos = videos;
		this.fechaCreacion = LocalDate.now();
	}

	public ListaVideos() {
	}
	
	public void addVideo(Video video) {
		this.videos.add(video);
	}

	public void deleteVideo(Video video) {
		this.videos.remove(video);
	}

	public String getNombreLista() {
		return nombreLista;
	}

	public void setNombreLista(String nombreLista) {
		this.nombreLista = nombreLista;
	}

	public List<Video> getVideos() {
		return videos;
	}

	public void setVideos(List<Video> videos) {
		this.videos = videos;
	}

	public String getFechaCreacion() {
		return fechaCreacion.toString();
	}

	public void setFechaCreacion(LocalDate fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public String getNumVideos() {
		int numero = this.videos.size();
		return Integer.toString(numero);
	}
	
	@Override
	public String toString() {
		return "ListaVideos [nombreLista = " + nombreLista + ", videos = " + videos + "]";
	}

}
