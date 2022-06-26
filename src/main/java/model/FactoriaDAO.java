package model;

public class FactoriaDAO extends AbsFactoriaDAO {
	@Override
	public IUsuarioDAO getUsuarioDAO() {
		return new UsuarioDAO();
	}

	@Override
	public IVideoDAO getVideoDAO() {
		return new VideoDAO();
	}

	@Override
	public IListaVideosDAO getListaVideosDAO() {
		return new ListaVideosDAO();
	}

	@Override
	public IEtiquetaDAO getEtiquetaDAO() {
		return new EtiquetaDAO();
	}

}
