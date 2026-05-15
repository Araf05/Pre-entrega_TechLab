# TechLab - Sistema de Gestión de Ecommerce

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)

Un sistema de consola robusto desarrollado en Java para la gestión de productos y procesamiento de pedidos en un entorno de comercio electrónico. El proyecto implementa principios de Programación Orientada a Objetos (POO), manejo de excepciones personalizadas, validación de datos implacable y una arquitectura basada en capas (Model-Service-UI).

<img width="392" height="229" alt="image" src="https://github.com/user-attachments/assets/2c5822d0-0f60-48d2-a068-29850e0549b2" />

---
## Tecnologías
*    **IDE:** Visual Studio Code
*    **Lenguaje:** Java 25.0.1

---

## 🚀 Características Principales

*   **Gestión Completa de Productos (CRUD):** Alta, lectura, actualización y eliminación de artículos comerciales con asignación automatizada de IDs.
*   **Procesamiento Inteligente de Pedidos:** Flujo dinámico para la creación de carritos de compras compuestos por múltiples líneas de pedido.
*   **Control Automatizado de Stock:** Descuento automático de existencias al confirmar artículos y reposición inmediata si una línea de pedido es cancelada o modificada.
*   **Validación de Datos en Tiempo Real:** Filtros de seguridad que previenen valores negativos en precios, textos vacíos o compras que superen el stock disponible.
*   **Interfaz de Consola Estilizada:** Menús intuitivos diseñados mediante caracteres Box-Drawing para una experiencia de usuario limpia y profesional.

---

## 🏗️ Arquitectura del Proyecto

El código está organizado bajo una estructura de paquetes limpia y escalable:
```text
com.techlab.ecommerce
│
├── model          # Entidades de negocio (Producto, Pedido, LineaPedido)
├── service        # Lógica de negocio y control de colecciones
├── ui             # Controladores de la interfaz de usuario por consola
├── util           # Validadores de datos y lectura segura de tipos
└── exception      # Excepciones personalizadas del dominio (Stock, No Encontrado)
```

---


## 🛠️ Modelos de Datos Relevantes

### 1. Producto 
Representa la unidad comercial base del sistema.

*    **Atributos:** id, nombre, stock, categoria, precio.

### 3. Línea de Pedido
Actúa como el intermediario (carrito) que vincula un producto con una cantidad específica, aislando el precio unitario histórico del momento de la compra.

*    **Atributos:** id, producto (Producto), cantidad, precioUnitario.
*    **Métodos Clave:** calcularSubtotal().

### 4. Pedido
Agrupa múltiples líneas de pedido, gestionando las marcas de tiempo y recalculando el coste total de forma reactiva.

*    **Atributos:** id, fecha (Timestamp), lineasPedido (List), costoTotal.

---


## 💻 Instalación

Ejecución local
  1. Clona este repositorio en tu máquina local:

```bash
git clone [https://github.com/Araf05/Pre-entrega_TechLab.git](https://github.com/Araf05/Pre-entrega_TechLab.git)
```
  2. Navega al directorio raíz del proyecto.
  3. Compila y ejecuta la clase `Main.java`:

 ```bash
   javac com/techlab/ecommerce/Main.java
   java com.techlab.ecommerce.Main
```

---

## 📊 Datos de Prueba Automatizados
Para facilitar la evaluación del sistema, el archivo Main.java precarga automáticamente el inventario inicial con los siguientes productos:
*    ☕ Cafe (Stock: 30 | Categoría: Bebidas | Precio: $3500.00)
*    🧀 Queso Cremoso (Stock: 200 | Categoría: Lacteos | Precio: $4500.50)
*    🍌 Manzana (Stock: 100 | Categoría: Verdulería | Precio: $1500.00)
*    🧴 Pan Lactal (Stock: 400 | Categoría: Panificados | Precio: $5600.00)

--- 

## 🛡️ Robustez y Control de Errores
El software captura activamente fallos comunes en tiempo de ejecución para evitar cierres inesperados mediante bloques try-catch personalizados:

*    **InputMismatchException:** Evita colapsos si el usuario ingresa letras en campos numéricos.
*    **StockInsuficienteException:** Bloquea transacciones comerciales si el stock actual es menor a la cantidad solicitada.
*    **ProductoNoEncontradoException / PedidoNoEncontradoException:** Gestiona búsquedas fallidas de IDs inexistentes.









