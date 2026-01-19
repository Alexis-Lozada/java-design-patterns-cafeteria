package com.cafeteria.servicios;

import com.cafeteria.interfaces.IPago;

public class ProxyPago implements IPago {

    private PagoReal servicioDePagoReal;
    private double saldoCliente;

    public ProxyPago(double saldoInicial) {
        this.saldoCliente = saldoInicial;
    }

    @Override
    public void procesarPago(double monto) {
        System.out.println("--- Iniciando transacción segura (Proxy) ---");

        if (monto <= 0) {
            System.out.println("ERROR: No se puede cobrar un monto negativo o cero.");
            return;
        }

        if (saldoCliente < monto) {
            System.out.println("ERROR: Fondos insuficientes en la tarjeta.");
            return;
        }

        if (servicioDePagoReal == null) {
            servicioDePagoReal = new PagoReal(); // Lazy Initialization (Creación tardía)
        }

        // Descontar el saldo
        saldoCliente -= monto;

        // Llamar al servicio real
        servicioDePagoReal.procesarPago(monto);
    }
}