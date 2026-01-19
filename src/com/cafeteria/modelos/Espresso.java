package com.cafeteria.modelos;

import com.cafeteria.interfaces.IBebida;

public class Espresso implements IBebida {
    @Override
    public double getCosto() {
        return 25.0;
    }

    @Override
    public String getDescripcion() {
        return "Café Espresso";
    }
}