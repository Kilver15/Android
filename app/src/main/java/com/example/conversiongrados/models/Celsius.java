package com.example.conversiongrados.models;

public class Celsius extends Grado {
    public Celsius(Double valor, String unidad) {
        super(valor, unidad);
    }

    public Fahrenheit CtoFahrenheit() {
        double fahrenheitValue = getValor() * 1.8 + 32;
        return new Fahrenheit(fahrenheitValue, "F");
    }

    public Kelvin CtoKelvin() {
        double kelvinValue = getValor() + 273.15;
        return new Kelvin(kelvinValue, "K");
    }
}
