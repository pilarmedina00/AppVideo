package model;

public abstract class AbsFactoriaDAO {

	private static AbsFactoriaDAO unicaInstancia;
	public static final String FACTORIA_DAO = "model.FactoriaDAO";

	@SuppressWarnings("deprecation")
	public static AbsFactoriaDAO getInstancia(String tipo) throws ExceptionDAO {
		if (unicaInstancia == null)
			try {
				unicaInstancia = (AbsFactoriaDAO) Class.forName(tipo).newInstance();
			} catch (Exception e) {
				throw new ExceptionDAO(e.getMessage());
			}
		return unicaInstancia;
	}

	public static AbsFactoriaDAO getInstancia() throws ExceptionDAO {
		if (unicaInstancia == null)
			return getInstancia(AbsFactoriaDAO.FACTORIA_DAO);
		else
			return unicaInstancia;
	}

	protected AbsFactoriaDAO() {
	}

	public abstract IUsuarioDAO getUsuarioDAO();

	public abstract IVideoDAO getVideoDAO();

	public abstract IListaVideosDAO getListaVideosDAO();

	public abstract IEtiquetaDAO getEtiquetaDAO();
}
