package Unidad3y4.ListaSimple;

public class Main {
    public static void main(String[] args) {
        // Creando lista simple
        ListaSimple lista = new ListaSimple();

        System.out.println("La lista esta vacia? "+lista.estaVacia()+"\n");

        // Probando inserciones
        lista.insertarAlFinal(10);
        lista.insertarAlFinal(20);
        lista.insertarAlFinal(30);
        lista.insertarAlInicio(5);

        // Deberia mostrar: 5 -> 10 -> 20 -> 30 -> null
        lista.mostrar();

        // Probando busquedas
        System.out.println("\nEl 20 esta en la lista? "+lista.buscar(20));
        System.out.println("El 99 esta en la lista? "+lista.buscar(99));

        System.out.println("\nEliminando el numero 20 (del centro)...");
        lista.eliminar(20);

        // Deberia mostrar: 5 -> 10 -> 30 -> null (del )
        lista.mostrar();
    }
}
