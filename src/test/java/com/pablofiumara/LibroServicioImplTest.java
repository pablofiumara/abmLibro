package com.pablofiumara;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import com.pablofiumara.dao.LibroDAO;
import com.pablofiumara.modelo.Libro;
import com.pablofiumara.servicio.LibroServicioImpl;

public class LibroServicioImplTest {

	@Mock
	private LibroDAO libroDAO;
    private LibroServicioImpl libroServicio;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        libroServicio = new LibroServicioImpl();
        libroServicio.setLibroDAO(libroDAO);
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testListarLibro() throws Exception {
    	//creo libro
        Libro libro = new Libro();
        libro.setTitulo("test: titulo de un libro");

        //cuando lista.
        List mockedLista = mock(List.class);
        //agrego algo a la lista...
        mockedLista.add("123");
        //...pero digo que al buscar el primer elemento de la lista, devuelvo el libro creado
        when(libroDAO.buscarLosLibros()).thenReturn(mockedLista);
        when(mockedLista.get(0)).thenReturn(libro);

        //creo lista con todos los libros
        List librosLista = libroDAO.buscarLosLibros();
        assertNotNull(librosLista);
        //tomo el primer libro de la lista
        Libro testLibro = (Libro) librosLista.get(0);

        assertNotNull(testLibro);
        //el primer libro de la lista debe ser el que creé
        assertEquals("Chequeo el título de libro", "test: titulo de un libro", testLibro.getTitulo());
    }
}