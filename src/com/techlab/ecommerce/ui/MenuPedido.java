package com.techlab.ecommerce.ui;

import java.util.Scanner;

import com.techlab.ecommerce.model.Pedido;
import com.techlab.ecommerce.model.LineaPedido;
import com.techlab.ecommerce.service.PedidoService;
import com.techlab.ecommerce.service.ProductoService;
import com.techlab.ecommerce.util.Validador;

public class MenuPedido {
    private final PedidoService pedidoService;
    private final ProductoService productoService;
    private final Scanner sc;

    public MenuPedido(Scanner sc, PedidoService pedidoService, ProductoService productoService) {
        this.sc = sc;
        this.pedidoService = pedidoService;
        this.productoService = productoService;
    }

    public void mostrarMenu() {
        System.out.printf(
                "╔════════════════════════════════════════════════════════════════╗\n" +
                        "║                     SISTEMA DE GESTIÓN - TECHLAB               ║\n" +
                        "╠════════════════════════════════════════════════════════════════╣\n" +
                        "║                                                                ║\n" +
                        "║   [1]  Crear Pedido                                            ║\n" +
                        "║   [2]  Listar Pedidos                                          ║\n" +
                        "║   [3]  Buscar Pedido por Id                                    ║\n" +
                        "║                                                                ║\n" +
                        "║   [6]  Volver al Menu de Productos                             ║\n" +
                        "║   [7]  Salir                                                   ║\n" +
                        "║                                                                ║\n" +
                        "╚════════════════════════════════════════════════════════════════╝\n");
    }

    private void agregarProducto(Pedido pedido) {
        LineaPedido linea = new LineaPedido();

        linea.setProducto(
                productoService.buscarPorId(
                        Validador.leerEntero(sc, "Ingrese el id del producto: ")));

        linea.setCantidad(Validador.leerEntero(sc, "Ingrese la cantidad que desea: "));

        pedidoService.creaLineaPedido(pedido, linea);

        System.out.println("[OK] Producto agregado al carrito.");
        System.out.println(linea);
    }

    public void crearPedido() {
        Pedido pedido = new Pedido();
        int cantidadLineas = Validador.leerEntero(sc, "Ingrese la cantidad de Productos del Pedido: ");

        for (int i = 0; i <= cantidadLineas; i++) {
            System.out.println("Producto #" + (i + 1));
            agregarProducto(pedido);
        }

        pedidoService.registrarPedido(pedido);
        System.out.println("[OK] Tu pedido ha sido creado.");
    }

    public void mostrarPedidos() {
        System.out.println("Listado de pedidos: ");
        for (Pedido p : pedidoService.listarPedidos()) {
            System.out.println(p);
        }
    }

    public void buscarPorId() {
        int id = Validador.leerEntero(sc, "Ingrese el id del pedido: ");
        Pedido p = pedidoService.buscarPedidoId(id);
        System.out.println("[OK] Pedido encontrado: ");
        System.out.println(p);
    }

}
