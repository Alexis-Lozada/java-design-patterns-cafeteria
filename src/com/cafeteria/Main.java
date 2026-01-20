package com.cafeteria;

import com.cafeteria.core.CajaRegistradora;
import com.cafeteria.core.GestorVentas;
import com.cafeteria.decoradores.Chocolate;
import com.cafeteria.decoradores.Leche;
import com.cafeteria.interfaces.IBebida;
import com.cafeteria.interfaces.IPago;
import com.cafeteria.modelos.Espresso;
import com.cafeteria.servicios.ProxyPago;

public class Main {
    public static void main(String[] args) {

        System.out.println("=== SISTEMA CAFETERÍA ===\n");

        IPago metodoDePago = new ProxyPago(100.0);
        GestorVentas miCafeteria = new GestorVentas(metodoDePago);

        System.out.println("--- CLIENTE 1 ---");

        // Crear la bebida (Decorator)
        IBebida bebida = new Espresso();
        bebida = new Leche(bebida);
        bebida = new Chocolate(bebida);

        // La cafetería procesa la orden usando la herramienta que le inyectamos
        miCafeteria.procesarOrden(bebida);

        System.out.println("\n---------------------------------------------------------\n");

        // Verificación final del Singleton
        System.out.println("Balance final en Caja: $" + CajaRegistradora.getInstancia().getBalance());
    }
}