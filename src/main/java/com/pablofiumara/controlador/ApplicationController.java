package com.pablofiumara.controlador;


import com.pablofiumara.wsdl.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pablofiumara.servicio.*;

@Controller
public class ApplicationController {
    
    @Autowired
    CurrencyService currencyService;
    
    
	@RequestMapping(value = "/testing", method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String printWelcome() {
		GetCityForecastByZIPResponse response = currencyService
				.getCityForecastByZip("94304");

		StringBuilder builder = new StringBuilder();
		builder.append("<html><body><pre>");
		builder.append(currencyService.printResponse(response));
		builder.append("</pre></body></html>");
		return builder.toString();
	}


}