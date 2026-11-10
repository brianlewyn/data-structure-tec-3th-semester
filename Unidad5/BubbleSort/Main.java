package Unidad5.BubbleSort;

public class Main {
    public static void imprimirPruebaDeArreglo(String nombre, int[] arreglo) {
        System.out.printf("\n ---------- " + nombre + " ---------- \n\n");
        
        System.out.print("Arreglo original: ");
        BubbleSort.imprimirArreglo(arreglo);
        
        BubbleSort.ordenar(arreglo);
        
        System.out.print("Arreglo ordenado: ");
        BubbleSort.imprimirArreglo(arreglo);
    }

    public static void main(String[] args) {
        int[] ejemplo = {6, 1, 5, 8, 3, 2, 7, 4};
        imprimirPruebaDeArreglo("Ejemplo de Clase", ejemplo);

        int[] mejorCaso = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        imprimirPruebaDeArreglo("Mejor Caso", mejorCaso);

        int[] casoPromedio = {6, 1, 10, 5, 8, 3, 2, 9, 7, 4};
        imprimirPruebaDeArreglo("Caso Promedio", casoPromedio);

        int[] peorCaso = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        imprimirPruebaDeArreglo("Peor Caso", peorCaso);
    }
}
