# Sistema de Cafetería con Patrones de Diseño

Este proyecto es un ejemplo didáctico desarrollado en **Java** para demostrar la implementación práctica de patrones de diseño de software fundamentales. Simula un sistema de punto de venta para una cafetería ficticia.

## Objetivo
Mostrar cómo resolver problemas comunes de arquitectura de software utilizando:
1.  **Singleton**: Para manejar una única instancia de la Caja Registradora.
2.  **Decorator**: Para crear bebidas complejas con múltiples ingredientes (extras) sin crear infinitas subclases.
3.  **Proxy**: Para simular y validar transacciones de pago de forma segura antes de contactar al banco.
4.  **Dependency Injection (DI)**: Para desacoplar la lógica de ventas de la implementación del pago, facilitando la escalabilidad y el mantenimiento.

## Estructura del Proyecto

El código está organizado por paquetes para facilitar su comprensión:

* `src/com/cafeteria/interfaces`: Contratos (`IBebida`, `IPago`).
* `src/com/cafeteria/modelos`: Bebidas base (`Espresso`, `Te`).
* `src/com/cafeteria/decoradores`: Ingredientes extra (`Leche`, `Chocolate`, `Canela`).
* `src/com/cafeteria/core`: Lógica de negocio (`GestorVentas`) y estado global (`CajaRegistradora` - Singleton).
* `src/com/cafeteria/servicios`: Lógica de pagos (`ProxyPago`, `PagoReal`).

## Cómo ejecutarlo

1.  Clona el repositorio:
    ```bash
    git clone https://github.com/Alexis-Lozada/java-design-patterns-cafeteria.git
    ```
2.  Abre el proyecto en tu IDE favorito (IntelliJ, Eclipse, VS Code).
3.  Ejecuta el archivo `Main.java`.

## Patrones Explicados en el Código

### Singleton
Se usa en la clase `CajaRegistradora` para asegurar que todas las ventas del día se sumen en un único lugar, independientemente de dónde se realice la venta.

### Decorator
Permite agregar ingredientes a las bebidas dinámicamente.
*Ejemplo:* `new Chocolate(new Leche(new Espresso()))` crea un objeto que suma los costos de cada capa.

### Proxy
Se usa en `ProxyPago` para intermediar entre el cliente y el sistema de cobro (`PagoReal`). Valida si el cliente tiene saldo suficiente antes de intentar procesar la transacción.

### Dependency Injection (Inyección de Dependencias)
Implementado en la clase `GestorVentas`. En lugar de que esta clase cree su propia forma de cobrar (con `new`), recibe una instancia de `IPago` a través de su **constructor**.
*Beneficio:* Permite cambiar el método de pago (ej. de Proxy a PayPal) desde el `Main` sin tener que modificar el código interno del gestor de ventas.

---
Hecho con ☕ y Java.