package com.pablofiumara.dao;

import java.util.List;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pablofiumara.modelo.Libro;

@Repository
public class LibroDAOImpl implements LibroDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
	    this.sessionFactory = sessionFactory;
	}


	@SuppressWarnings("unchecked")
	@Transactional
	public List<Libro> buscarLosLibros() {
		return sessionFactory.getCurrentSession().createQuery("from Libro").list(); //Libro es el nombre de la clase modelo, no  de la tabla
	}

	@Transactional
	public void addTeam(Libro team) {
		sessionFactory.getCurrentSession().save(team);
	}

}