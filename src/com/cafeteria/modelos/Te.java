package com.cafeteria.modelos;

import com.cafeteria.interfaces.IBebida;

public class Te implements IBebida {
    @Override
    public double getCosto() {
        return 20.0;
    }

    @Override
    public String getDescripcion() {
        return "Té Clásico";
    }
}