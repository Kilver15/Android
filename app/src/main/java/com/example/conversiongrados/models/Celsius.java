package com.example.conversiongrados.models;

public class Celsius extends Grado {
    public Celsius(Double valor, String unidad) {
        super(valor, unidad);
    }

    public Fahrenheit parseF(Celsius c){
        return new Fahrenheit(c.getValor()*1.8+32,"F");
    }
    public  Kelvin parseK(Celsius c){
        return  new Kelvin(c.getValor() + 273.15, "K");
    }
}
