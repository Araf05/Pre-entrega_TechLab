package com.techlab.ecommerce;

import java.util.Scanner;

import com.techlab.ecommerce.service.ProductoService;
import com.techlab.ecommerce.exception.ProductoNoEncontradoException;
import com.techlab.ecommerce.exception.StockInsufiecienteException;
import com.techlab.ecommerce.model.Producto;
import com.techlab.ecommerce.ui.MenuProducto;
import com.techlab.ecommerce.util.Validador;

public class Menu {
    public static void main(String[] args) throws Exception {
        ProductoService service = new ProductoService();
        Scanner sc = new Scanner(System.in);
        MenuProducto menu = new MenuProducto(sc, service);

        cargarDatosDePrueba(service);

        int opcion;

        do {
            menu.mostrarMenu();
            opcion = Validador.leerEntero(sc, "Elija una opción: ");

            try {
                switch (opcion) {
                    case 1 -> menu.agregarProducto();
                    case 2 -> menu.mostrarProductos();
                    case 3 -> menu.actualizarProducto();
                    case 4 -> menu.eliminarProducto();
                    case 5 -> menu.buscarProducto();
                    case 6 -> System.out.println("Cerrando el programa... ¡Hasta luego!");
                    default -> System.out.println("Opcion invalida. Ingrese un número del 1 al 6");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Dato invalido: " + e.getMessage());
            } catch (ProductoNoEncontradoException | StockInsufiecienteException e) {
                System.out.println(e.getMessage());
            }

            System.out.println();

        } while (opcion != 6);

        sc.close();
    }

    public static void cargarDatosDePrueba(ProductoService service) {
        service.creaProducto(new Producto("Cafe", 30, "Bebidas", 3500.00));
        service.creaProducto(new Producto("Queso Cremoso", 200, "Lacteos", 4500.50));
        service.creaProducto(new Producto("Banana", 100, "Verdulería", 1500.00));
        service.creaProducto(new Producto("Shampoo", 400, "Perfumería", 5600.00));

    }

}
