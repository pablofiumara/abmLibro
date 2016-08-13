package com.pablofiumara.servicio;

import com.pablofiumara.wsdl.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;

@Service
public class CurrencyServiceImpl implements CurrencyService {

    @Autowired
    protected WebServiceTemplate webServiceTemplate;

    @Override
    public Double getConversionRate(Currency fromCurrency, Currency toCurrency) {
        ConversionRate conversionRate = new ObjectFactory().createConversionRate();
        conversionRate.setFromCurrency(fromCurrency);
        conversionRate.setToCurrency(toCurrency);

        ConversionRateResponse response = (ConversionRateResponse) webServiceTemplate.marshalSendAndReceive(conversionRate);

        return response.getConversionRateResult();
    }

}