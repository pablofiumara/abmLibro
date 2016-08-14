package com.pablofiumara.servicio;

import com.pablofiumara.wsdl.*;

import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Repository;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

@Repository
public class TiempoServicio extends WebServiceGatewaySupport{
	
	public TiempoServicio() {}
	public TiempoServicio(Jaxb2Marshaller marshaller) {
		this.setDefaultUri("http://wsf.cdyne.com/WeatherWS/Weather.asmx");
		this.setMarshaller(marshaller);
		this.setUnmarshaller(marshaller);
	}
	public GetCityForecastByZIPResponse getCityForecastByZip(String zipCode) {
		GetCityForecastByZIP request = new GetCityForecastByZIP();
		request.setZIP(zipCode);

		System.out.println();
		System.out.println("Requesting forecast for " + zipCode);
		
		GetCityForecastByZIPResponse response = (GetCityForecastByZIPResponse) getWebServiceTemplate().marshalSendAndReceive(request,new SoapActionCallback("http://ws.cdyne.com/WeatherWS/GetCityForecastByZIP"));
		return response;
	}	
}