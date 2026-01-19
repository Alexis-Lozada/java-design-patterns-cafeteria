package com.cafeteria.decoradores;

import com.cafeteria.interfaces.IBebida;

public class Chocolate extends BebidaDecorador {

    public Chocolate(IBebida bebida) {
        super(bebida);
    }

    @Override
    public double getCosto() {
        return bebidaDecorada.getCosto() + 8.0;
    }

    @Override
    public String getDescripcion() {
        return bebidaDecorada.getDescripcion() + ", Chocolate";
    }
}