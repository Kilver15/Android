package com.example.conversiongrados.models;

public class Fahrenheit extends Grado {
    public Fahrenheit(Double valor, String unidad) {
        super(valor, unidad);
    }

    public Celsius FtoCelsius() {
        double celsiusValue = (getValor() - 32) / 1.8;
        return new Celsius(celsiusValue, "C");
    }

    public Kelvin FtoKelvin() {
        double kelvinValue = (getValor() + 459.67) * 5/9;
        return new Kelvin(kelvinValue, "K");
    }
}
