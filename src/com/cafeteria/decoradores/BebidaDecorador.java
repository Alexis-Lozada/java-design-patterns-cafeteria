package com.cafeteria.decoradores;

import com.cafeteria.interfaces.IBebida;

public abstract class BebidaDecorador implements IBebida {
    protected IBebida bebidaDecorada;

    public BebidaDecorador(IBebida bebida) {
        this.bebidaDecorada = bebida;
    }

    @Override
    public double getCosto() {
        return bebidaDecorada.getCosto();
    }

    @Override
    public String getDescripcion() {
        return bebidaDecorada.getDescripcion();
    }
}