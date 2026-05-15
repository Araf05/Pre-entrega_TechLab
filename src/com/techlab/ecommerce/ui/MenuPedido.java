package com.techlab.ecommerce.ui;

import java.util.Scanner;

import com.techlab.ecommerce.model.Pedido;
import com.techlab.ecommerce.model.Producto;
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

    private void agregarProducto(Pedido pedido) {
        Producto p = (
                productoService.buscarPorId(
                        Validador.leerEntero(sc, "Ingrese el id del producto: ")));

        int cantidad = (Validador.leerEntero(sc, "Ingrese la cantidad que desea: "));

        LineaPedido linea = new LineaPedido(p, cantidad);

        pedidoService.creaLineaPedido(pedido, linea);

        System.out.println("\n[OK] Producto agregado al carrito.\n");
        System.out.println(linea);
    }

    public void crearPedido() {
        Pedido pedido = new Pedido();
        int cantidadLineas = Validador.leerEntero(sc, "\nIngrese la cantidad de Productos del Pedido: ");

        for (int i = 0; i < cantidadLineas; i++) {
            System.out.println("\nProducto #" + (i + 1));
            agregarProducto(pedido);
        }

        pedidoService.registrarPedido(pedido);
        System.out.println("\n[OK] Tu pedido ha sido creado.\n");
        System.out.println(pedido);
    }

    public void mostrarPedidos() {
        System.out.println("\nListado de pedidos: ");
        for (Pedido p : pedidoService.listarPedidos()) {
            System.out.println(p);
        }
    }

    public void buscarPorId() {
        int id = Validador.leerEntero(sc, "Ingrese el id del pedido: ");
        Pedido p = pedidoService.buscarPedidoId(id);
        System.out.println("\n[OK] Pedido encontrado: \n");
        System.out.println(p);
    }

}
