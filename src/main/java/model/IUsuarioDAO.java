package model;

import java.util.List;

public interface IUsuarioDAO {

	void crearUsuario(Usuario usuario);

	void borrarUsuario(Usuario usuario);

	void modificarUsuario(Usuario usuario);

	Usuario getUsuario(int id);

	List<Usuario> getUsuarios();

}
