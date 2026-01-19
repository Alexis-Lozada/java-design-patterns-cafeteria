package com.cafeteria;

import com.cafeteria.core.CajaRegistradora;
import com.cafeteria.decoradores.Canela;
import com.cafeteria.decoradores.Chocolate;
import com.cafeteria.decoradores.Leche;
import com.cafeteria.interfaces.IBebida;
import com.cafeteria.interfaces.IPago;
import com.cafeteria.modelos.Espresso;
import com.cafeteria.modelos.Te;
import com.cafeteria.servicios.ProxyPago;

public class Main {
    public static void main(String[] args) {

        System.out.println("=== ABRIENDO CAFETERÍA (Sistema v1.0) ===\n");

        // ---------------------------------------------------------
        // CASO 1: Un cliente pide un "Mocaccino" (Espresso + Leche + Chocolate)
        // ---------------------------------------------------------
        System.out.println("--- CLIENTE 1: Ordenando bebida ---");

        // 1. Empezamos con la base
        IBebida bebida1 = new Espresso();

        // 2. Aplicamos DECORATOR: Envolvemos el objeto dinámicamente
        bebida1 = new Leche(bebida1); // Agregamos Leche
        bebida1 = new Chocolate(bebida1); // Agregamos Chocolate

        System.out.println("Pedido: " + bebida1.getDescripcion());
        System.out.println("Costo: $" + bebida1.getCosto());

        // 3. Aplicamos PROXY: El cliente intenta pagar
        // Simulamos que el cliente tiene $50 en su tarjeta
        IPago servicioPago1 = new ProxyPago(50.0);

        servicioPago1.procesarPago(bebida1.getCosto());

        System.out.println("\n---------------------------------------------------------\n");

        // ---------------------------------------------------------
        // CASO 2: Un cliente pide un Té con Canela, pero NO tiene saldo
        // ---------------------------------------------------------
        System.out.println("--- CLIENTE 2: Ordenando bebida ---");

        IBebida bebida2 = new Te();
        bebida2 = new Canela(bebida2); // Decorator

        System.out.println("Pedido: " + bebida2.getDescripcion());
        System.out.println("Costo: $" + bebida2.getCosto());

        // Simulamos que el cliente solo tiene $10 en su tarjeta (Insuficiente)
        IPago servicioPago2 = new ProxyPago(10.0);

        // El Proxy debería detectar falta de fondos y NO llamar al Singleton ni al
        // Banco
        servicioPago2.procesarPago(bebida2.getCosto());

        System.out.println("\n---------------------------------------------------------\n");

        // ---------------------------------------------------------
        // CASO 3: Cierre de caja (Verificar Singleton)
        // ---------------------------------------------------------
        System.out.println("--- CIERRE DE DÍA ---");

        // Accedemos a la instancia única.
        // Solo debería tener el dinero del Cliente 1. El Cliente 2 fue rechazado.
        double totalDia = CajaRegistradora.getInstancia().getBalance();

        System.out.println("Total vendido hoy: $" + totalDia);
    }
}