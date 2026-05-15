package com.techlab.ecommerce.util;

import java.util.InputMismatchException;
import java.util.Scanner;
import com.techlab.ecommerce.exception.StockInsufiecienteException;
import com.techlab.ecommerce.model.Pedido;

public class Validador {

    /// Validacion de valores de nuevos Productos
    public static void validarNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("\n[ERROR] El nombre no puede estar vacio.\n");
        }
    }

    public static void validarStock(int stock) {
        if (stock < 0) {
            throw new StockInsufiecienteException("\n[ERROR] El stock no puede ser negativo.\n");
        }
    }

    public static void validarPrecio(double precio) {
        if (precio < 0) {
            throw new IllegalArgumentException("\n[ERROR] El precio no puede ser negativo.\n");
        }
    }

    public static void validarCategoria(String categoria) {
        if (categoria == null || categoria.trim().isEmpty()) {
            throw new IllegalArgumentException("\n[ERROR] La categoría no puede estar vacia.\n");
        }
    }

    /// Validación de valores de nuevos Pedidos
    public static void validarCantidad(int cantidad) {
        if (cantidad <= 0) {
            throw new IllegalArgumentException("\n[ERROR] La cantidad no puede ser negativa.\n");
        }
    }

    public static void validarStockPedido(int stock, int cantidad) {
        if (stock < cantidad) {
            throw new StockInsufiecienteException("\n[ERROR] El stock es insuficiente.\n");
        }
    }

    public static void validarPedido(Pedido pedido) {
        if(pedido.getLineasPedido().isEmpty()) {
            throw new IllegalArgumentException("\n[ERROR] El pedido no puede estar vacío\n");
        }
    }

    /// Lectura segura de datos en consola
    public static int leerEntero(Scanner sc, String mensaje) {
        while (true) {
            System.out.println(mensaje);
            try {
                int valor = sc.nextInt();
                sc.nextLine();
                return valor;
            } catch (InputMismatchException e) {
                System.out.println("\n[ERROR] Debe ingresar un número entero. Intente nuevamente.\n");
                sc.nextLine();
            }
        }
    }

    public static Double leerDouble(Scanner sc, String mensaje) {
        while (true) {
            System.out.println(mensaje);
            try {
                double valor = sc.nextDouble();
                sc.nextLine();
                return valor;
            } catch (InputMismatchException e) {
                System.out.println("\n[ERROR] Debe ingresar un número decimal. Intente nuevamente.\n");
                sc.nextLine();
            }
        }
    }

    public static String leerTexto(Scanner sc, String mensaje) {
        System.out.println(mensaje);
        return sc.nextLine();
    }

    public static boolean confirmar(Scanner sc, String mensaje) {
        while (true) {
            System.out.println(mensaje);
            int respuesta = sc.nextInt();
            if (respuesta == 1) {
                return true;
            }

            if (respuesta == 0) {
                return false;
            }

            System.out.println("\n[ERROR] Ingrese una opción válida.\n");
        }
    }

}
