package org.example;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Producto> productos = new ArrayList<>();

        int opcion;
        do {
            System.out.println("\n--- MENÚ DE TIENDA ---");
            System.out.println("|  1. Crear producto                       | ");
            System.out.println("|  2. Vender producto                      | ");
            System.out.println("|  3. Reponer stock                        | ");
            System.out.println("|  4. Aplicar descuento                    | ");
            System.out.println("|  5. Aumentar precio                      | ");
            System.out.println("|  6. Mostrar información de productos     | ");
            System.out.println("|  7. Calcular valor total en inventario   | ");
            System.out.println("|  8. Comparar precios                     | ");
            System.out.println("|  9. Salir                                | ");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();
            switch (opcion) {
                case 1 -> {
                    System.out.print("Ingrese el nombre del producto: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese el precio del producto: ");
                    double precio = scanner.nextDouble();
                    System.out.print("Ingrese la cantidad en stock: ");
                    int cantidad = scanner.nextInt();
                    scanner.nextLine();

                    productos.add(new Producto(nombre, precio, cantidad));
                    System.out.println("Producto agregado con éxito.");
                }
                case 2 -> {
                    System.out.print("Ingrese el nombre del producto a vender: ");
                    String nombre = scanner.nextLine();
                    for (Producto producto : productos) {
                        if (producto.getNombre().equalsIgnoreCase(nombre)) {
                            System.out.print("Ingrese la cantidad a vender: ");
                            int cantidad = scanner.nextInt();
                            scanner.nextLine();
                            producto.vender(scanner);
                            break;
                        }
                    }
                }
                case 3 -> {
                    System.out.print("Ingrese el nombre del producto a reponer: ");
                    String nombre = scanner.nextLine();
                    for (Producto producto : productos) {
                        if (producto.getNombre().equalsIgnoreCase(nombre)) {
                            System.out.print("Ingrese la cantidad a reponer: ");
                            int cantidad = scanner.nextInt();
                            scanner.nextLine();
                            producto.reponer(scanner);
                            break;
                        }
                    }
                }
                case 4 -> {
                    System.out.print("Ingrese el nombre del producto a aplicar descuento: ");
                    String nombre = scanner.nextLine();
                    for (Producto producto : productos) {
                        if (producto.getNombre().equalsIgnoreCase(nombre)) {
                            producto.aplicarDescuento();
                            break;
                        }
                    }
                }
                case 5 -> {
                    System.out.print("Ingrese el nombre del producto a aumentar precio: ");
                    String nombre = scanner.nextLine();
                    for (Producto producto : productos) {
                        if (producto.getNombre().equalsIgnoreCase(nombre)) {
                            System.out.print("Ingrese el porcentaje de aumento: ");
                            double porcentaje = scanner.nextDouble();
                            scanner.nextLine();
                            producto.aumentarPrecio(scanner);
                            break;
                        }
                    }
                }
                case 6 -> {
                    if (productos.isEmpty()) {
                        System.out.println("No hay productos en la tienda");
                    } else {
                        System.out.println("\n--- Lista de Productos ---");
                        for (Producto producto : productos) {
                            producto.mostrarInformacion();
                            System.out.println("------------------------");
                        }
                    }
                }
                case 7 -> {
                    double total = 0;
                    for (Producto producto : productos) {
                        total += producto.calcularValorInventario();
                    }
                    System.out.println("El valor total en inventario es: $" + total);
                }
                case 8 -> {
                    if (productos.size() < 2) {
                        System.out.println("Debe haber al menos dos productos para comparar");
                        break;
                    }

                    System.out.print("Ingrese el nombre del primer producto: ");
                    String nombre1 = scanner.nextLine();
                    System.out.print("Ingrese el nombre del segundo producto: ");
                    String nombre2 = scanner.nextLine();

                    Producto p1 = null, p2 = null;

                    for (Producto producto : productos) {
                        if (producto.getNombre().equalsIgnoreCase(nombre1)) {
                            p1 = producto;
                        }
                        if (producto.getNombre().equalsIgnoreCase(nombre2)) {
                            p2 = producto;
                        }
                    }

                    if (p1 != null && p2 != null && !p1.getNombre().equalsIgnoreCase(p2.getNombre())) {
                        p1.compararPrecio(p2);
                    } else {
                        System.out.println("Selección inválida");
                    }
                }
                case 9 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción inválida, intente nuevamente");
            }
        }while (opcion != 9);
        scanner.close();
    }
}