package InventoryControlSystem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BinarySearchTree inventory = new BinarySearchTree();

        Scanner scanner = new Scanner(System.in);
        ConsoleUI ui = new ConsoleUI(scanner);

        // Precargar productos para pruebas
        // inventory.insert(new Product("Manzana",  50, 1.20));
        // inventory.insert(new Product("Banana",   40, 0.90));
        // inventory.insert(new Product("Pera",     35, 1.45));
        // inventory.insert(new Product("Aguacate", 25, 2.80));
        // inventory.insert(new Product("Naranja",  60, 1.10));
        // inventory.insert(new Product("Uva",      30, 3.50));
        // inventory.insert(new Product("Sandia",   15, 4.75));

        String option;
        do {
            ui.showMenu();
            
            option = ui.readOption();

            System.out.println();

            switch (option) {
                case "a": {
                    Product product = ui.readNewProduct();
                    inventory.insert(product);
                    break;
                }
                case "b": {                    
                    String name = ui.readProductName("> Opción [b) Buscar producto por nombre]");
                    Product product = inventory.search(name);
                    
                    if (product != null) {
                        product.showDetails();
                    } else {
                        ui.printNotFound(name);
                    }

                    break;
                }
                case "c": {
                    String name = ui.readProductName("> Opción [c) Dar de baja / eliminar producto]");
                    Product deleted = inventory.delete(name);
                    
                    if (deleted != null) {
                        ui.printDeleted(deleted);
                    } else {
                        ui.printNotFound(name);
                    }

                    break;
                }
                case "d":
                    inventory.show();
                    break;

                case "e":
                    ui.printGoodbye();
                    break;
                
                default:
                    ui.printInvalidOption();
                    break;
            }

            System.out.println();

        } while (!option.equals("e"));

        scanner.close();
    }
}