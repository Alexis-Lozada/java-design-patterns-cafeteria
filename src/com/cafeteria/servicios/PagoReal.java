package com.cafeteria.servicios;

import com.cafeteria.interfaces.IPago;
import com.cafeteria.core.CajaRegistradora;

public class PagoReal implements IPago {

    @Override
    public void procesarPago(double monto) {
        System.out.println("   [Banco] Procesando tarjeta...");

        try {
            Thread.sleep(1000); // 1 seg
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("   [Banco] Pago autorizado correctamente.");
        CajaRegistradora.getInstancia().registrarVenta(monto);
    }
}