package com.example.conversiongrados.models;

public class Kelvin extends Grado {
    public Kelvin(Double valor, String unidad) {
        super(valor, unidad);
    }

    public Celsius KtoCelsius() {
        double celsiusValue = getValor() - 273.15;
        return new Celsius(celsiusValue, "C");
    }

    public Fahrenheit KtoFahrenheit() {
        double fahrenheitValue = (getValor() * 9/5) - 459.67;
        return new Fahrenheit(fahrenheitValue, "F");
    }
}
