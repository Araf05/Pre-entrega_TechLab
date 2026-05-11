package com.techlab.ecommerce.model;

public class Producto {
    private int id;
    private String nombre;
    private int stock;
    private String categoria;
    private double precio;

    /// Constructores
    public Producto() {
    }

    public Producto(String nombre, int stock, String categoria, double precio) {
        this.setNombre(nombre);
        this.setCategoria(categoria);
        this.setPrecio(precio);
        this.setStock(stock);
    }

    /// Getters
    public String getNombre() {
        return nombre;
    }

    public int getStock() {
        return stock;
    }

    public String getCategoria() {
        return categoria;
    }

    public double getPrecio() {
        return precio;
    }

    public int getId() {
        return this.id;
    }

    /// Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setId(int contadorId) {
        this.id = contadorId;
    }

    /// Override
    @Override
    public String toString() {
        return String.format(
                "│ %-4d │ %-24s │ %-19s │ $%10.2f │ %-5d │",
                id,
                nombre,
                categoria,
                precio,
                stock);
    }

}
