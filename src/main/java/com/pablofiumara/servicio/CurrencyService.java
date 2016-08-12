package com.pablofiumara.servicio;

import com.pablofiumara.wsdl.*;

public interface CurrencyService {
    Double getConversionRate(Currency fromCurrency, Currency toCurrency);
}