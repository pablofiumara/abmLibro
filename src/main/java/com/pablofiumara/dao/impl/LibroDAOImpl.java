package com.pablofiumara.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.pablofiumara.dao.LibroDAO;
import com.pablofiumara.entity.Libro;

@Transactional
public class LibroDAOImpl implements LibroDAO {

  private SessionFactory sessionFactory;

  public void setSessionFactory(SessionFactory sessionFactory) {
      this.sessionFactory = sessionFactory;
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