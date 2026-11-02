package InventoryControlSystem;

public class BinarySearchTree {
    private Node root;
    
    public BinarySearchTree() {
        this.root = null;
    }

    public void insert(Product product) {
        this.root = insertNode(root, product);
    }

    private Node insertNode(Node current, Product product) {
        if (current == null) {
            return new Node(product);
        }

        int cmp = product.name.compareTo(current.product.name);

        if (cmp < 0) {
            current.left = insertNode(current.left, product);
            return current;
        }
        
        if (cmp > 0) {
            current.right = insertNode(current.right, product);
            return current;
        }
        
        // Producto ya existente: actualizamos stock y precio.
        current.product.stock = product.stock;
        current.product.price = product.price;
        return current;
    }

    public Product search(String name) {
        Node current = searchNode(root, name);
        return (current != null) ? current.product : null;
    }

    private Node searchNode(Node current, String name) {
        if (current == null) return null;

        int cmp = name.compareTo(current.product.name);
        
        if (cmp < 0) return searchNode(current.left, name);
        if (cmp > 0) return searchNode(current.right, name);
        
        return current;
    }

    public Product delete(String name) {
        Product target = search(name);
        if (target != null) {
            this.root = deleteNode(root, name);
        }
        return target;
    }

    private Node deleteNode(Node current, String name) {
        if (current == null) return null;

        int cmp = name.compareTo(current.product.name);
        
        if (cmp < 0) {
            current.left = deleteNode(current.left, name);
            return current;
        }

        if (cmp > 0) {
            current.right = deleteNode(current.right, name);
            return current;
        }

        if (current.left == null && current.right == null) return null;
        if (current.left == null) return current.right;
        if (current.right == null) return current.left;

        Node successor = minorNode(current.right);
        current.product = successor.product;
        current.right = deleteNode(current.right, successor.product.name);
        return current;
    }

    private Node minorNode(Node current) {
        while (current.left != null) current = current.left;
        return current;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void show() {
        final String LINE = "=".repeat(100);

        System.out.println(LINE);
        System.out.println("> Inventario");
        System.out.println(LINE);

        if (isEmpty()) {
            System.out.println("(El inventario está vacío)");
        } else {
            showNode(this.root);
        }
        
        System.out.println(LINE);
    }

    private void showNode(Node current) {
        if (current != null) {
            showNode(current.left);
            current.product.show();
            showNode(current.right);
        }
    }
}
