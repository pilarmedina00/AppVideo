package model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.*;

public class Etiqueta  implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "idTag")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name = "nombre")
	private String nombre;
	
	public Etiqueta() {
	}

	public Etiqueta(String nombre) {
		this.nombre = nombre;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Etiqueta [nombre = " + nombre + "]";
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Etiqueta etiqueta = (Etiqueta) o;
		return nombre.equals(etiqueta.nombre);
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}

}
