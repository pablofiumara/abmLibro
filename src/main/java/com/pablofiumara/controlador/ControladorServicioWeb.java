package com.pablofiumara.controlador;

import java.util.List;

import com.pablofiumara.wsdl.*;
import com.pablofiumara.servicio.*;

import javax.servlet.http.HttpServletRequest;

import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
public class ControladorServicioWeb {

	@RequestMapping(value = "/servicio-web", method = RequestMethod.GET)
	public String getServicioWebPagina() {		
		return "servicio-web-formulario";
	}

	@RequestMapping(value = "/resultado-servicio-web", method = RequestMethod.POST)
	public void postResultadoServicioWeb(HttpServletRequest request, Model modelo) {		
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		//paquete donde se encuentran los archivos .java generados por el Servicio Web
		marshaller.setContextPath("com.pablofiumara.wsdl");
		
		
		TiempoServicioImpl unTiempoServicio = new TiempoServicioImpl(marshaller);
		String elCodigoPostal = request.getParameter("codigoPostal").trim();
		GetCityForecastByZIPResponse response = unTiempoServicio.buscarPronosticoParaCiudadPorCodigoPostal(elCodigoPostal);
		ForecastReturn pronosticoRespuesta = response.getGetCityForecastByZIPResult();
		
		
		if (pronosticoRespuesta.isSuccess()) {
			List<Forecast> pronosticos = pronosticoRespuesta.getForecastResult().getForecast();
			modelo.addAttribute("unaRespuestaPronostico", pronosticoRespuesta);
			modelo.addAttribute("pronosticosLista", pronosticos);			
		}
	}
}
