package com.cafeteria.decoradores;

import com.cafeteria.interfaces.IBebida;

public class Canela extends BebidaDecorador {

    public Canela(IBebida bebida) {
        super(bebida);
    }

    @Override
    public double getCosto() {
        return bebidaDecorada.getCosto() + 2.0;
    }

    @Override
    public String getDescripcion() {
        return bebidaDecorada.getDescripcion() + ", Canela";
    }
}