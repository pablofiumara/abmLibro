package com.pablofiumara.controlador;




import com.pablofiumara.wsdl.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pablofiumara.servicio.*;

@Controller
public class ApplicationController {

    @Autowired
    CurrencyService currencyService;

    @RequestMapping(value = "/testing", method = RequestMethod.GET)
    public String welcome(ModelMap model) {
        model.addAttribute("msgArgument",
                "Maven Java Web Application Project: Success!");
        return "test";

    }

    @RequestMapping(value = "/Print/{arg}", method = RequestMethod.GET)
    public String welcomeName(@PathVariable String arg, ModelMap model) {
        model.addAttribute("msgArgument",
                "Maven Java Web Application Project, input variable: " + arg);

        return "index";
    }

    @RequestMapping(value = "/convert/{fromCur}/{toCur}/{amount}", method = RequestMethod.GET)
    public String convert(@PathVariable String fromCur,@PathVariable String toCur, @PathVariable Double amount,ModelMap model) {



        Currency fromCurrency = Currency.fromValue(fromCur.toUpperCase());
        Currency toCurrency = Currency.fromValue(toCur.toUpperCase());
        Double conversionRate = currencyService.getConversionRate(fromCurrency, toCurrency);

        Double result = amount * conversionRate;

        model.addAttribute("msgArgument","Maven Java Web Application Project, input variable: " + result);

        return "index";
    }

}