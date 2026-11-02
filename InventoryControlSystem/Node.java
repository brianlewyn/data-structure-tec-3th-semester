package InventoryControlSystem;

public class Node {
    public Product product;
    public Node left;
    public Node right;

    public Node(Product product) {
        this.product = product;
        this.left = null;
        this.right = null;
    }
}
