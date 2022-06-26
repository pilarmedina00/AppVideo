package model;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import persistence.HibernateUtil;

public class EtiquetaDAO implements IEtiquetaDAO {
	@Override
	public void crearEtiqueta(Etiqueta etiqueta) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			session.save(etiqueta);
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
	public void borrarEtiqueta(Etiqueta etiqueta) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			session.delete(etiqueta);
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
	public void modificarEtiqueta(Etiqueta etiqueta) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			session.update(etiqueta);
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
	public Etiqueta getEtiqueta(int id) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Etiqueta etiqueta = session.get(Etiqueta.class, id);
			session.getTransaction().commit();
			return etiqueta;
			
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
	public List<Etiqueta> getEtiquetas() {

		List<Etiqueta> etiquetas = new ArrayList<>();
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			etiquetas = session.createQuery("FROM Etiqueta").list();
			session.getTransaction().commit();
			return etiquetas;
			
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
}
