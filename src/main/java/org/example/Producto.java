package org.example;
import java.util.ArrayList;
import java.util.Scanner;
public class Producto {
    private String nombre;
    private double precio;
    private int cantidad;

    public Producto() {
    }

    public Producto(String nombre, double precio, int cantidad) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", cantidad=" + cantidad +
                '}';
    }
    public void vender(Scanner scanner) {
        if (cantidad == 0) {
            System.out.println("No hay stock disponible de " + nombre + ".");
            return;
        }

        int cantidadVendida;
        do {
            System.out.println("No hay suficiente cantidad en stock");
            System.out.println("Stock disponible de " + nombre + ": " + cantidad);
            System.out.print("Ingrese la cantidad a vender: ");
            cantidadVendida = scanner.nextInt();
            scanner.nextLine();
            if (cantidadVendida > cantidad) {
                System.out.println("No hay suficiente stock. Intente con una cantidad menor.");
            }
        } while (cantidadVendida > cantidad);

        cantidad -= cantidadVendida;
        System.out.println("Se vendieron " + cantidadVendida + " unidades de " + nombre + ". Stock restante: " + cantidad);
    }
    public void reponer(Scanner scanner) {
        int cantidadNueva;
        do {
            System.out.print("Ingrese la cantidad a reponer (debe ser mayor a 0): ");
            cantidadNueva = scanner.nextInt();
            scanner.nextLine();

            if (cantidadNueva <= 0) {
                System.out.println("La cantidad debe ser mayor a 0");
            }
        } while (cantidadNueva <= 0);

        cantidad += cantidadNueva;
        System.out.println("Se repusieron " + cantidadNueva + " unidades de " + nombre + ". Stock actual: " + cantidad);
    }
    public void aplicarDescuento(){
        precio -= precio*0.02;
        System.out.println("Se aplico un descuento del 2% a"+nombre+" Su precio ahora es de: $"+precio);
    }
    public void aumentarPrecio(Scanner scanner) {
        double porcentaje;
        do {
            System.out.print("Ingrese el porcentaje de aumento: ");
            porcentaje = scanner.nextDouble();
            scanner.nextLine();

            if (porcentaje <= 0) {
                System.out.println("El porcentaje debe ser mayor a 0");
            }
        } while (porcentaje <= 0);

        precio += precio * (porcentaje / 100);
        System.out.println("El precio de " + nombre + " aumentó en " + porcentaje + "%. Nuevo precio: $" + precio);
    }
    public void mostrarInformacion(){
        System.out.println(" | Producto: "+nombre+" | ");
        System.out.println(" | Precio: "+precio+" | ");
        System.out.println(" | Cantidad en stock: "+cantidad+" | ");
    }
    public double calcularValorInventario(){
        return precio*cantidad;
    }
    public void compararPrecio(Producto otroProducto) {
        if (this.precio > otroProducto.precio) {
            System.out.println(nombre + " es más caro que " + otroProducto.nombre);
        } else if (this.precio < otroProducto.precio) {
            System.out.println(nombre + " es más barato que " + otroProducto.nombre);
        } else {
            System.out.println(nombre + " y " + otroProducto.nombre + " tienen el mismo precio");
        }
    }

}
