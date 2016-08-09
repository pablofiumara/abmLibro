package com.pablofiumara.controlador;

import com.pablofiumara.servicio.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


public class ControladorPrincipalTest{

    @InjectMocks
    ControladorPrincipal indexController;
    @Mock
    LibroServicio libroServicio;

    MockMvc mockMvc;

    @Before
    public void before() throws Exception {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(indexController).build();
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void testIndex() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/mostrarLibros"))
                .andExpect(MockMvcResultMatchers.view().name("lista-de-libros"));
    }



}