package com.cafeteria.decoradores;

import com.cafeteria.interfaces.IBebida;

public class Leche extends BebidaDecorador {

    public Leche(IBebida bebida) {
        super(bebida);
    }

    @Override
    public double getCosto() {
        return bebidaDecorada.getCosto() + 5.0;
    }

    @Override
    public String getDescripcion() {
        return bebidaDecorada.getDescripcion() + ", Leche";
    }
}