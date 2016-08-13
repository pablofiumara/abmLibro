package com.pablofiumara.servicio;

import com.pablofiumara.wsdl.*;

public interface CurrencyService {

	public GetCityForecastByZIPResponse getCityForecastByZip(String zipCode);

	public String printResponse(GetCityForecastByZIPResponse response);

}