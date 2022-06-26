package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "Usuario")
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "idUser")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "username")
	private String username;

	@Column(name = "password")
	private String password;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "apellidos")
	private String apellidos;

	@Column(name = "email")
	private String email;

	@Column(name = "fechaNacimiento")
	private LocalDate fechaNacimiento;

	@Column(name = "premium")
	private boolean esPremium;

	@Column(name = "numVideosVistos")
	private int totalVideosVistos;

	@Column(name = "fechaRegistro")
	private LocalDate fechaRegistro;

	@Column(name = "filtro")
	private IFiltro tipoFiltro;

	@Fetch(FetchMode.SELECT)
	@ManyToMany(fetch = FetchType.EAGER)
	private List<ListaVideos> listasReproduccion;

	@Fetch(FetchMode.SELECT)
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "USUARIO_RECIENTES")
	private List<Video> listaRecientes;

	@Fetch(FetchMode.SELECT)
	@ElementCollection(fetch = FetchType.EAGER)
	private Map<Video, Integer> masVistos;

	public Usuario() {

	}

	public Usuario(String nombre, String apellidos, String correo, String username, String password,
			LocalDate fechaNacimiento) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = correo;
		this.username = username;
		this.password = password;
		this.fechaNacimiento = fechaNacimiento;
		this.esPremium = false;
		this.totalVideosVistos = 0;
		this.listasReproduccion = new ArrayList<>();
		this.listaRecientes = new ArrayList<>();
		this.masVistos = new HashMap<>();

		setTipoFiltro("NoFiltro");
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public boolean isPremium() {
		return esPremium;
	}

	public void setPremium(boolean premium) {
		this.esPremium = premium;
	}

	public IFiltro getTipoFiltro() {
		return tipoFiltro;
	}
	
	// Filtro escogido por el usuario
	public void setTipoFiltro(String tipoFiltro) {
		switch (tipoFiltro) {
		case "NoFiltro":
			this.tipoFiltro = new NoFiltro();
			break;

		case "Impopulares":
			this.tipoFiltro = new FiltroImpopulares();
			break;

		case "MisListas":
			this.tipoFiltro = new FiltroMisListas();
			break;

		case "Menores":
			this.tipoFiltro = new FiltroMenores();
			break;
			
		case "NombresLargos":
			this.tipoFiltro = new FiltroNombresLargos();
			break;
		}
	}

	public List<ListaVideos> getListasReproduccion() {
		return this.listasReproduccion;
	}

	public LocalDate getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(LocalDate fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public int getTotalVideosVistos() {
		return totalVideosVistos;
	}
	
	@Override
	public String toString() {
		return "Usuario [nombre = " + nombre + ", apellidos = " + apellidos + ", email = " + email + ", username = "
				+ username + ", password = " + password + ", fechaNacimiento = " + fechaNacimiento + ", premium = "
				+ esPremium + "]";
	}

	public void addVideoVisto() {
		this.totalVideosVistos++;
	}

	public List<Video> getListaRecientes() {
		return this.listaRecientes;
	}

	public void addVideoMasVistos(Video video) {
		if (masVistos.containsKey(video)) {
			int visto = masVistos.get(video);
			masVistos.put(video, visto + 1);
		} else {
			masVistos.put(video, 1);
		}
	}

	public Map<Video, Integer> getMasVistos() {
		return masVistos;
	}

	public ListaVideos getListaVideos(String lista) {
		for (ListaVideos playlist : this.listasReproduccion) {
			if (playlist.getNombreLista().equals(lista)) {
				return playlist;
			}
		}
		return null;
	}

	public void addListaVideos(ListaVideos nuevaLista) {
		this.listasReproduccion.add(nuevaLista);
	}
	
	public void removeListaVideos(ListaVideos lista) {
		this.listasReproduccion.remove(lista);
	}

	public ListaVideos createListaVideos(String lista, List<Video> videos) {
		return new ListaVideos(lista, videos);
	}

	// Para actualizar la lista de recientes
	public void addRecientes(Video video) {
		if (!this.listaRecientes.contains(video)) {
			if (this.listaRecientes.size() >= 5) {
				// Se elimina el video que antes se vio
				this.listaRecientes.remove(4);
				// Se anade en el primer lugar el visto mas recientemente
				this.listaRecientes.add(0, video);
			} else {
				this.listaRecientes.add(0, video);
			}
		}
	}
}