package Unidad3y4.ListaSimple;

import Unidad3y4.PilaDinamica.Nodo;

public class ListaSimple {
    public Nodo cabeza;

    public ListaSimple() {
        this.cabeza = null;
    }

    public boolean estaVacia() {
        return cabeza == null;
    }

    public void insertarAlInicio(int x) {
        Nodo nuevo = new Nodo(x);
        nuevo.siguiente = cabeza;
        cabeza = nuevo;
    }

    public void insertarAlFinal(int x) {
        Nodo nuevo = new Nodo(x);

        if (estaVacia()) {
            cabeza = nuevo;
            return;
        }

        Nodo actual = cabeza;

        while (actual.siguiente != null) {
            actual = actual.siguiente;
        }

        actual.siguiente = nuevo;
    }

    public void mostrar() {
        if (estaVacia()) {
            System.out.println("La lista esta vacia");
            return;
        }

        System.out.print("Lista: ");

        for (Nodo actual = cabeza; actual != null; actual = actual.siguiente) {
            System.out.print("[" + actual.dato + "] -> ");
        }
        
        System.out.println("null");
    }

    public boolean buscar(int x) {
        for (Nodo actual = cabeza; actual != null; actual = actual.siguiente) {
            if (actual.dato == x) {
                return true;
            }
        }
        return false;
    }

    public void eliminar(int x) {
        if (estaVacia()) {
            System.out.println("La lista esta vacia");
            return;
        }

        if (cabeza.dato == x) {
            cabeza = cabeza.siguiente;
            return;
        }

        Nodo actual = cabeza;

        while (actual.siguiente != null && actual.siguiente.dato != x) {
            actual = actual.siguiente;
        }

        // si actual.siguiente es distinto de nulo, significa que 
        if (actual.siguiente != null) {
            actual.siguiente = actual.siguiente.siguiente;
        }
    }
}
