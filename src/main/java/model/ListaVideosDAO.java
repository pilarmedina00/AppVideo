package model;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import persistence.HibernateUtil;

public class ListaVideosDAO implements IListaVideosDAO {
	
	@Override
	public ListaVideos getListaVideos(int id) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			ListaVideos listaVideos = session.get(ListaVideos.class, id);
			session.getTransaction().commit();
			return listaVideos;
			
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
	public List<ListaVideos> getListasVideos() {

		List<ListaVideos> listasVideos = new ArrayList<>();
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			listasVideos = (ArrayList<ListaVideos>) session.createQuery("FROM ListaVideos").list();
			session.getTransaction().commit();
			return listasVideos;
			
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
	public void crearListaVideos(ListaVideos listaVideos) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			session.save(listaVideos);
			session.getTransaction().commit();
			
		} catch (RuntimeException e) {
			if (transaction != null)
				transaction.rollback();
			e.printStackTrace();
			
		} finally {
			session.close();
		}
	}

	@Override
	public void borrarListaVideos(ListaVideos listaVideos) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			session.delete(listaVideos);
			session.getTransaction().commit();
			
		} catch (RuntimeException e) {
			if (transaction != null)
				transaction.rollback();
			e.printStackTrace();
			
		} finally {
			session.close();
		}
	}

	@Override
	public void modificarListaVideos(ListaVideos listaVideos) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			session.update(listaVideos);
			session.getTransaction().commit();

		} catch (RuntimeException e) {
			if (transaction != null)
				transaction.rollback();
			e.printStackTrace();
			
		} finally {
			session.close();
		}
	}
}

