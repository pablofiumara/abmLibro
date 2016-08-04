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

	private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @SuppressWarnings("unchecked")
    public List<Libro> getTeams() {
        Session session = sessionFactory.openSession();
        try {
            Query query = session.createQuery("from Libro l");
            List<Libro> bookList = query.list();
            return bookList;
        } finally {
            session.close();
        }
    }


}