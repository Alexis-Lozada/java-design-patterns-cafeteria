package com.cafeteria.core;

import com.cafeteria.interfaces.IBebida;
import com.cafeteria.interfaces.IPago;

public class GestorVentas {

    private IPago servicioDePago;

    public GestorVentas(IPago servicioDePago) {
        this.servicioDePago = servicioDePago;
    }

    public void procesarOrden(IBebida bebida) {
        System.out.println("Procesando orden: " + bebida.getDescripcion());
        System.out.println("Total a cobrar: $" + bebida.getCosto());

        servicioDePago.procesarPago(bebida.getCosto());
    }
}