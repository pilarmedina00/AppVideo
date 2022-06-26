package model;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import persistence.HibernateUtil;

public class UsuarioDAO implements IUsuarioDAO {
	
	@Override
	public Usuario getUsuario(int codigo) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Usuario u = session.get(Usuario.class, codigo);
			session.getTransaction().commit();
			return u;
			
		} catch (RuntimeException e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
			
		} finally {
			session.close();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> getUsuarios() {

		List<Usuario> listaUsuarios = new ArrayList<>();
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			listaUsuarios = (ArrayList<Usuario>) session.createQuery("FROM Usuario").list();
			session.getTransaction().commit();
			return listaUsuarios;
			
		} catch (RuntimeException e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
			
		} finally {
			session.close();
		}
		return null;
	}
	
	@Override
	public void crearUsuario(Usuario usuario) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			session.save(usuario);
			session.getTransaction().commit();
			
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			
		} finally {
			session.close();
		}
	}

	@Override
	public void borrarUsuario(Usuario usuario) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			session.delete(usuario);
			session.getTransaction().commit();
			
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			
		} finally {
			session.close();
		}
	}

	@Override
	public void modificarUsuario(Usuario usuario) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.update(usuario);
			session.getTransaction().commit();
			
		} catch (RuntimeException e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
			
		} finally {
			session.close();
		}
	}
}
