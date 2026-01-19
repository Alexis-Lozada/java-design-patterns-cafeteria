package com.cafeteria.core;

public class CajaRegistradora {

    private static CajaRegistradora instancia;
    private double balanceDiario;

    private CajaRegistradora() {
        this.balanceDiario = 0.0;
        System.out.println("--- CAJA REGISTRADORA INICIADA ---");
    }

    public static CajaRegistradora getInstancia() {
        if (instancia == null) {
            instancia = new CajaRegistradora();
        }
        return instancia;
    }

    public void registrarVenta(double monto) {
        this.balanceDiario += monto;
        System.out.printf("Caja: Se ingresaron $%.2f. Total acumulado: $%.2f%n", monto, balanceDiario);
    }

    public double getBalance() {
        return balanceDiario;
    }
}