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

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String getServicioWebPagina() {		
		return "servicio-web";
	}

	@RequestMapping(value = "/resultado-servicio-web", method = RequestMethod.POST)
	public void postResultadoServicioWeb(HttpServletRequest request, Model model) {		
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setContextPath("com.pablofiumara.wsdl");
		WeatherClient client = new WeatherClient(marshaller);
		String zip = request.getParameter("zip").trim();
		GetCityForecastByZIPResponse response = client.getCityForecastByZip(zip);
		ForecastReturn forecastReturn = response
				.getGetCityForecastByZIPResult();
		if (forecastReturn.isSuccess()) {
			List<Forecast> forecasts = forecastReturn.getForecastResult()
					.getForecast();
			model.addAttribute("forecastReturn", forecastReturn);
			model.addAttribute("forecasts", forecasts);
			client.printResponse(response);
		}
	}
}
