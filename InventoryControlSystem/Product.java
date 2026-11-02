package InventoryControlSystem;

public class Product {
    public String name;
    public int stock;
    public double price;

    public Product(String name, int stock, double price) {
        this.name = name;
        this.stock = stock;
        this.price = price;
    }

    public void show() {
        System.out.printf("%-70s [stock: %3d] [precio: $%7.2f]%n", name, stock, price);
    }

    public void showDetails() {
        final String LINE = "=".repeat(50);
        
        System.out.printf("%n"+LINE+"%n");
        System.out.println(name);
        System.out.println(LINE);
        
        System.out.printf("Stock: %d%n", stock);
        System.out.printf("Precio: $%.2f%n", price);
        
        System.out.println(LINE);
    }
}
