package com.pablofiumara.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.pablofiumara.dao.LibroDAO;
import com.pablofiumara.modelo.Libro;


@Repository
public class LibroDAOImpl implements LibroDAO {

	@Autowired
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
/*
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}*/

	@SuppressWarnings("unchecked")
	public List<Libro> getTeams() {
		return getCurrentSession().createQuery("from Libro").list();
	}

	@SuppressWarnings("unchecked")
	public List<Libro> mostrarLosLibros() {
		Session session = this.sessionFactory.getCurrentSession();

		List<Libro> unaLista = session.createQuery("from Libro").list();

		return unaLista;
	}

	public Integer getMaxId() {
		Session session = this.sessionFactory.getCurrentSession();
		String sql = "Select max(l.id) from Libro l ";
		Query query = session.createQuery(sql);
		Integer maxLibroId = (Integer) query.uniqueResult();
		if (maxLibroId == null) {
			return 0;
		}
		return maxLibroId;
	}

	public void agregarLibro(String unTitulo) {

		Libro unLibro = new Libro();
		unLibro.setId(getMaxId() + 1);
		unLibro.setTitulo(unTitulo);

		Session session = this.sessionFactory.getCurrentSession();
		session.persist(unLibro);
	}

}