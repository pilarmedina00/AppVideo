package model;


import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Video")
public class Video {

	@Id
	@Column(name = "idVideo")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "titulo")
	private String titulo;

	@Column(name = "URL")
	private String url;

	@Column(name = "numReproducciones")
	private int numReproducciones;

	@Fetch(FetchMode.SELECT)
	@ManyToMany(fetch = FetchType.EAGER)
	private List<Etiqueta> etiquetas;

	public Video() {
	}

	public Video(String titulo, String url) {
		this.titulo = titulo;
		this.url = url;
		this.numReproducciones = 0;
		this.etiquetas = new LinkedList<>();
	}

	public void addReproduccion() {
		this.numReproducciones++;
	}

	public String getReproducciones() {
		return Integer.toString(numReproducciones);
	}

	public boolean addEtiqueta(Etiqueta etiqueta) {
		for (Etiqueta e : etiquetas) {
			if (e.getNombre().equals(etiqueta.getNombre())) {
				return false;
			}
		}
		etiquetas.add(etiqueta);
		return true;
	}

	public boolean removeEtiqueta(Etiqueta etiqueta) {
		for (Etiqueta e : etiquetas) {
			if (e.equals(etiqueta)) {
				etiquetas.remove(e);
				return true;
			}
		}
		return false;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getNumReproducciones() {
		return numReproducciones;
	}

	public List<Etiqueta> getEtiquetas() {
		return Collections.unmodifiableList(this.etiquetas);
	}

	public void setEtiquetas(List<Etiqueta> etiquetas) {
		this.etiquetas = etiquetas;
	}

	@Override
	public String toString() {
		return "Video [titulo = " + titulo + ", URL = " + url + ", numReproduciones = " + numReproducciones + "]";
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Video video = (Video) o;
		return titulo.equals(video.titulo) && url.equals(video.url);
	}

	@Override
	public int hashCode() {
		return Objects.hash(titulo, url);
	}
}
