package com.techlab.ecommerce.ui;

import java.util.Scanner;
import com.techlab.ecommerce.service.ProductoService;
import com.techlab.ecommerce.model.Producto;
import com.techlab.ecommerce.util.Validador;

public class MenuProducto {
    private final ProductoService service;
    private final Scanner sc;

    public MenuProducto(Scanner sc, ProductoService service) {
        this.sc = sc;
        this.service = service;
    }

    public void mostrarMenu() {
        System.out.printf(
                "╔════════════════════════════════════════════════════════════════╗\n" +
                        "║                     SISTEMA DE GESTIÓN - TECHLAB               ║\n" +
                        "╠════════════════════════════════════════════════════════════════╣\n" +
                        "║                                                                ║\n" +
                        "║   [1]  Agregar producto                                        ║\n" +
                        "║   [2]  Listar productos                                        ║\n" +
                        "║   [3]  Actualizar producto                                     ║\n" +
                        "║   [4]  Eliminar producto                                       ║\n" +
                        "║   [5]  Buscar producto por id                                  ║\n" +
                        // "║ [6] Listar pedidos ║\n" +
                        "║                                                                ║\n" +
                        "║   [6]  Salir                                                   ║\n" +
                        "║                                                                ║\n" +
                        "╚════════════════════════════════════════════════════════════════╝\n");
    }

    public void agregarProducto() {
        Producto p = new Producto();

        p.setNombre(Validador.leerTexto(sc, "Ingrese el nombre del producto: "));
        p.setStock(Validador.leerEntero(sc, "Ingrese el stock del producto: "));
        p.setCategoria(Validador.leerTexto(sc, "Ingrese la categoría del producto: "));
        p.setPrecio(Validador.leerDouble(sc, "Ingrese el precio del producto: "));

        p = service.creaProducto(p);
        System.out.println("[OK] Producto agregado exitosamente.");
        System.out.println(p);
    }

    public void mostrarProductos() {
        System.out.println("Listado de productos: ");
        for (Producto p : service.leerTodos()) {
            System.out.println(p);
        }
    }

    public void buscarProducto() {
        int id = Validador.leerEntero(sc, "Ingrese el id del producto: ");
        System.out.println("[OK] Producto encontrado: ");
        System.out.println(service.buscarPorId(id));
    }

    public void actualizarProducto() {
        int id = Validador.leerEntero(sc, "Ingrese el id del producto: ");
        Producto p = service.buscarPorId(id);

        p.setNombre(Validador.leerTexto(sc, "Ingrese el nombre del producto: "));
        p.setStock(Validador.leerEntero(sc, "Ingrese el stock del producto: "));
        p.setCategoria(Validador.leerTexto(sc, "Ingrese la categoría del producto: "));
        p.setPrecio(Validador.leerDouble(sc, "Ingrese el precio del producto: "));

        System.out.println("[OK] Producto actualizado exitosamente.");
        System.out.println(service.actualizar(id, p));

    }

    public void eliminarProducto() {
        int id = Validador.leerEntero(sc, "Ingrese el id del producto a eliminar: ");

        boolean confirmar = Validador.confirmar(sc,
                "El producto se eliminará definitivamente. ¿Desea continuar?\n" +
                        "[1] Continuar \n" +
                        "[0] Cancelar \n" +
                        "\nSeleccione una opción: ");

        if (confirmar) {
            service.eliminar(id);
            System.out.println("\n[OK] El producto ha sido eliminado.");
        } else {
            System.out.println("\n[CANCELADO] Operación cancelada por el usuario.");
        }

    }

}
