package com.pablofiumara.dao.impl;

import java.util.List;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pablofiumara.dao.LibroDAO;
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
	public List<Libro> getTeams() {
		return sessionFactory.getCurrentSession().createQuery("from Libro").list();
	}

}