package InventoryControlSystem;

import java.util.Scanner;

public class ConsoleUI {
    private static final String LINE = "=".repeat(50);
    private final Scanner scanner;

    public ConsoleUI(Scanner scanner) {
        this.scanner = scanner;
    }

    // ---------- Menú ----------

    public void showMenu() {
        System.out.printf("%n"+LINE+"%n");
        System.out.println("MENÚ PRINCIPAL");
        System.out.println(LINE);
        System.out.println("a) Registrar / insertar producto.");
        System.out.println("b) Buscar producto por nombre.");
        System.out.println("c) Dar de baja / eliminar producto.");
        System.out.println("d) Mostrar inventario completo.");
        System.out.println("e) Salir.");
        System.out.println(LINE);
    }

    public String readOption() {
        System.out.print("Elige una opción (a-e): ");
        return scanner.nextLine().trim().toLowerCase();
    }

    // ---------- Lectura de datos ----------

    public Product readNewProduct() {
        printHeader("> Opción [a) Registrar / insertar producto]");

        System.out.print("Nombre del producto: ");
        String name = scanner.nextLine().trim();

        int stock = readInt("Stock del producto: ");
        double price = readDouble("Precio del producto: $");

        System.out.println(LINE);
        return new Product(name, stock, price);
    }

    public String readProductName(String actionLabel) {
        printHeader(actionLabel);
        
        System.out.print("Nombre del producto: ");
        String name = scanner.nextLine().trim();
        
        System.out.println(LINE);
        return name;
    }

    // ---------- Mensajes ----------

    public void printHeader(String title) {
        System.out.println(LINE);
        System.out.println(title);
        System.out.println(LINE);
    }

    public void printNotFound(String name) {
        System.out.printf("%n> El producto \"%s\" no existe en el inventario.%n", name);
    }

    public void printDeleted(Product product) {
        System.out.printf("%n"+LINE+LINE+"%n");
        
        product.show();
        System.out.printf("> El producto \"%s\" fue eliminado del inventario.%n", product.name);
        
        System.out.println(LINE+LINE);
    }

    public void printInvalidOption() {
        System.out.println("[!] Opción inválida. Intenta de nuevo.");
    }

    public void printGoodbye() {
        System.out.println("> Saliendo del sistema de inventario. ¡Hasta pronto!");
    }

    // ---------- Lectura numérica segura ----------

    private int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("[!] Debes ingresar un número entero. Intenta de nuevo.");
            }
        }
    }

    private double readDouble(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Double.parseDouble(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("[!] Debes ingresar un número válido. Intenta de nuevo.");
            }
        }
    }
}