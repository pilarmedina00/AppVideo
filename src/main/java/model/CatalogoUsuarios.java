package model;

import java.util.*;

public class CatalogoUsuarios {
	private Map<String, Usuario> users;
	private Map<Integer, Usuario> idUsers;
	private static CatalogoUsuarios unicaInstancia;

	private AbsFactoriaDAO absFactoriaDAO;
	
	public static CatalogoUsuarios getUnicaInstancia() {
		if (unicaInstancia == null) {
			unicaInstancia = new CatalogoUsuarios();
		}
		return unicaInstancia;
	}

	private CatalogoUsuarios() {
		users = new HashMap<>();
		idUsers = new HashMap<>();
		try {
			absFactoriaDAO = AbsFactoriaDAO.getInstancia();
		} catch (ExceptionDAO e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		List<Usuario> usuarios = (List<Usuario>) absFactoriaDAO.getUsuarioDAO().getUsuarios();
		for (Usuario user : usuarios) {
			this.users.put(user.getUsername(), user);
			this.idUsers.put(user.getId(), user);
		}
	}

	public Usuario getUsuario(int id) {
		return this.idUsers.get(id);
	}

	public Usuario getUsuario(String username) {
		return this.users.get(username);
	}

	public void crearUsuario(Usuario usuario) {
		System.out.println("User added: " + usuario.toString());
		this.users.put(usuario.getUsername(), usuario);
		this.idUsers.put(usuario.getId(), usuario);
	}

}
