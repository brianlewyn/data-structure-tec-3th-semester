package Unidad6.BusquedaBinaria;

public class PracticaBusquedaBinaria {

    public static int busquedaBinaria(int[] arr, int clave) {
        int izq = 0;
        int der = arr.length - 1;

        while (izq <= der) {
            int mid = izq + (der - izq) / 2;

            if (arr[mid] == clave) {
                return mid;
            } 
            
            if (arr[mid] < clave) {
                izq = mid + 1;
            } else {
                der = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        // Arreglo previamente ordenado de menor a mayor
        int[] folios = {102, 115, 128, 140, 156, 173, 190, 205};

        int res1 = busquedaBinaria(folios, 173); // Esperado: 5
        int res2 = busquedaBinaria(folios, 130); // Esperado: -1

        System.out.println("Indice de 173: " + res1);
        System.out.println("Indice de 130: " + res2);
    }

}