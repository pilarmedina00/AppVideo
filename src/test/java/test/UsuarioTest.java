package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.time.LocalDate;

import org.junit.BeforeClass;
import org.junit.Test;

import model.Usuario;

public class UsuarioTest {
	static Usuario usuario;

	@BeforeClass
	public static void before() {
		usuario = new Usuario("Pilar", "Medina", "pilarmr00@hotmail.es", "pilarmr00", "contrasena2000",
				LocalDate.now());
	}

	@Test
	public void testGet() {
		assertEquals("test getNombre", "Pilar", usuario.getNombre());
		assertEquals("test getApellidos", "Medina", usuario.getApellidos());
		assertEquals("test getEmail", "pilarmr00@hotmail.es", usuario.getEmail());
		assertEquals("test getNick", "pilarmr00", usuario.getUsername());
		assertEquals("test getPassword", "contrasena2000", usuario.getPassword());
		assertEquals("test getFechaNacimiento", LocalDate.now(), usuario.getFechaNacimiento());
	}

	@Test
	public void testSet() {

		Usuario usuarioPrueba = new Usuario(usuario.getNombre(), usuario.getApellidos(), usuario.getEmail(),
				usuario.getUsername(), usuario.getPassword(), usuario.getFechaNacimiento());

		usuario.setNombre("Pepi");
		usuario.setApellidos("Rodriguez");
		usuario.setEmail("pepi63@hotmail.es");
		usuario.setUsername("pepi63");
		usuario.setPassword("contrasena63");
		usuario.setFechaNacimiento(LocalDate.of(1963, 30, 11));

		assertEquals("test getNombre", "Pepi", usuario.getNombre());
		assertEquals("test getApellidos", "Rodriguez", usuario.getApellidos());
		assertEquals("test getEmail", "pepi63@hotmail.es", usuario.getEmail());
		assertEquals("test getNick", "pepi63", usuario.getUsername());
		assertEquals("test getPassword", "contrasena63", usuario.getPassword());
		assertEquals("test getFechaNacimiento", LocalDate.of(1963, 30, 11), usuario.getFechaNacimiento());

		assertNotEquals("test setNombre", usuarioPrueba.getNombre(), usuario.getNombre());
		assertNotEquals("test setApellidos", usuarioPrueba.getApellidos(), usuario.getApellidos());
		assertNotEquals("test setEmail", usuarioPrueba.getEmail(), usuario.getEmail());
		assertNotEquals("test setUsername", usuarioPrueba.getUsername(), usuario.getUsername());
		assertNotEquals("test setPassword", usuarioPrueba.getPassword(), usuario.getPassword());
		assertNotEquals("test setFechaNacimiento", usuarioPrueba.getFechaNacimiento(), usuario.getFechaNacimiento());
	}
}
